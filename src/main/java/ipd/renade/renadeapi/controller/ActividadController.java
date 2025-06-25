package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.ActividadDTO;
import ipd.renade.renadeapi.model.Actividad;
import ipd.renade.renadeapi.service.IActividadService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/actividad")
@AllArgsConstructor
public class ActividadController {
    private final IActividadService actividadService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ActividadDTO>> findAll() {
        List<ActividadDTO> list=mapperUtil.mapList(actividadService.findAll(), ActividadDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ActividadDTO> findById(@PathVariable("id") Integer id) {
        Actividad object=actividadService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, ActividadDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ActividadDTO dto) {
        Actividad obj=actividadService.save(mapperUtil.map(dto,Actividad.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdActividad()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<ActividadDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody ActividadDTO dto) {
        dto.setIdActividad(id);
        Actividad obj=actividadService.update(id, mapperUtil.map(dto,Actividad.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ActividadDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        actividadService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/detalletitulo/{titulo}")
    public ResponseEntity<List<ActividadDTO>> findByTitulo(@PathVariable String titulo) {
        List<ActividadDTO> object = mapperUtil.mapList(
                actividadService.findByTitulo(titulo),
                ActividadDTO.class
        );
        return ResponseEntity.ok(object);
    }



}
