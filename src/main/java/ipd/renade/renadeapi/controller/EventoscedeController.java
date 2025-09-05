package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.EventoscedeDTO;
import ipd.renade.renadeapi.model.Eventoscede;
import ipd.renade.renadeapi.service.IEventoscedeService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/eventoscede")
@AllArgsConstructor
public class EventoscedeController {
    private final IEventoscedeService eventoscedeService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<EventoscedeDTO>> findAll() {
        List<EventoscedeDTO> list=mapperUtil.mapList(eventoscedeService.findAll(), EventoscedeDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EventoscedeDTO> findById(@PathVariable("id") Integer id) {
        Eventoscede object=eventoscedeService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, EventoscedeDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody EventoscedeDTO dto) {
        Eventoscede obj=eventoscedeService.save(mapperUtil.map(dto,Eventoscede.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEventoscede()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<EventoscedeDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody EventoscedeDTO dto) {
        dto.setIdEventoscede(id);
        Eventoscede obj=eventoscedeService.update(id, mapperUtil.map(dto,Eventoscede.class));
        return ResponseEntity.ok(mapperUtil.map(obj, EventoscedeDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        eventoscedeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
