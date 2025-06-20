package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.AlumnoDTO;
import ipd.renade.renadeapi.model.Alumno;
import ipd.renade.renadeapi.service.IAlumnoService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/alumno")
@AllArgsConstructor
public class AlumnoController {
    private final IAlumnoService alumnoService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> findAll() {
        List<AlumnoDTO> list=mapperUtil.mapList(alumnoService.findAll(), AlumnoDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> findById(@PathVariable("id") Integer id) {
        Alumno object=alumnoService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, AlumnoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody AlumnoDTO dto) {
        Alumno obj=alumnoService.save(mapperUtil.map(dto,Alumno.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdAlumno()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody AlumnoDTO dto) {
        dto.setIdAlumno(id);
        Alumno obj=alumnoService.update(id, mapperUtil.map(dto,Alumno.class));
        return ResponseEntity.ok(mapperUtil.map(obj, AlumnoDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        alumnoService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
