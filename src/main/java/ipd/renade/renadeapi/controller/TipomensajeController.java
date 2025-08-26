package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.TipomensajeDTO;
import ipd.renade.renadeapi.model.Tipomensaje;
import ipd.renade.renadeapi.service.ITipomensajeService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tipomensaje")
@AllArgsConstructor
public class TipomensajeController {
    private final ITipomensajeService tipomensajeService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipomensajeDTO>> findAll() {
        List<TipomensajeDTO> list=mapperUtil.mapList(tipomensajeService.findAll(), TipomensajeDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipomensajeDTO> findById(@PathVariable("id") Integer id) {
        Tipomensaje object=tipomensajeService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, TipomensajeDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipomensajeDTO dto) {
        Tipomensaje obj=tipomensajeService.save(mapperUtil.map(dto,Tipomensaje.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipomensaje()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<TipomensajeDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody TipomensajeDTO dto) {
        dto.setIdTipomensaje(id);
        Tipomensaje obj=tipomensajeService.update(id, mapperUtil.map(dto,Tipomensaje.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TipomensajeDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        tipomensajeService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
