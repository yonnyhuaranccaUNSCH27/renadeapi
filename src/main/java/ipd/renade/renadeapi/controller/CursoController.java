package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.CursoDTO;
import ipd.renade.renadeapi.model.Curso;
import ipd.renade.renadeapi.service.ICursoService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/curso")
@AllArgsConstructor
public class CursoController {
    private final ICursoService cursoService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> findAll() {
        List<CursoDTO> list=mapperUtil.mapList(cursoService.findAll(), CursoDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> findById(@PathVariable("id") Integer id) {
        Curso object=cursoService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, CursoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CursoDTO dto) {
        Curso obj=cursoService.save(mapperUtil.map(dto,Curso.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCurso()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody CursoDTO dto) {
        dto.setIdCurso(id);
        Curso obj=cursoService.update(id, mapperUtil.map(dto,Curso.class));
        return ResponseEntity.ok(mapperUtil.map(obj, CursoDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
