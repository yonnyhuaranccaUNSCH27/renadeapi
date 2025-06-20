package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.SeccionDTO;
import ipd.renade.renadeapi.model.Seccion;
import ipd.renade.renadeapi.service.ISeccionService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/seccion")
@AllArgsConstructor
public class SeccionController {
    private final ISeccionService seccionService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<SeccionDTO>> findAll() {
        List<SeccionDTO> list=mapperUtil.mapList(seccionService.findAll(), SeccionDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SeccionDTO> findById(@PathVariable("id") Integer id) {
        Seccion object=seccionService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, SeccionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody SeccionDTO dto) {
        Seccion obj=seccionService.save(mapperUtil.map(dto,Seccion.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSeccion()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<SeccionDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody SeccionDTO dto) {
        dto.setIdSeccion(id);
        Seccion obj=seccionService.update(id, mapperUtil.map(dto,Seccion.class));
        return ResponseEntity.ok(mapperUtil.map(obj, SeccionDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        seccionService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
