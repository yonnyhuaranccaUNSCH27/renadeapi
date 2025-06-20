package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.AnosDTO;
import ipd.renade.renadeapi.model.Anos;
import ipd.renade.renadeapi.service.IAnosService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/anos")
@AllArgsConstructor
public class AnosController {
    private final IAnosService anosService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<AnosDTO>> findAll() {
        List<AnosDTO> list=mapperUtil.mapList(anosService.findAll(), AnosDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AnosDTO> findById(@PathVariable("id") Integer id) {
        Anos object=anosService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, AnosDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody AnosDTO dto) {
        Anos obj=anosService.save(mapperUtil.map(dto,Anos.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdAnos()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<AnosDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody AnosDTO dto) {
        dto.setIdAnos(id);
        Anos obj=anosService.update(id, mapperUtil.map(dto,Anos.class));
        return ResponseEntity.ok(mapperUtil.map(obj, AnosDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        anosService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
