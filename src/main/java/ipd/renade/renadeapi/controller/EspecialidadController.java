package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.EspecialidadDTO;
import ipd.renade.renadeapi.model.Especialidad;
import ipd.renade.renadeapi.service.IEspecialidadService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/especialidad")
@AllArgsConstructor
public class EspecialidadController {
    private final IEspecialidadService especialidadService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<EspecialidadDTO>> findAll() {
        List<EspecialidadDTO> list=mapperUtil.mapList(especialidadService.findAll(), EspecialidadDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadDTO> findById(@PathVariable("id") Integer id) {
        Especialidad object=especialidadService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, EspecialidadDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody EspecialidadDTO dto) {
        Especialidad obj=especialidadService.save(mapperUtil.map(dto,Especialidad.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEspecialidad()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody EspecialidadDTO dto) {
        dto.setIdEspecialidad(id);
        Especialidad obj=especialidadService.update(id, mapperUtil.map(dto,Especialidad.class));
        return ResponseEntity.ok(mapperUtil.map(obj, EspecialidadDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        especialidadService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
