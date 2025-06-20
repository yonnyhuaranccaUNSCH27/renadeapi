package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.MatriculaDTO;
import ipd.renade.renadeapi.model.Matricula;
import ipd.renade.renadeapi.service.IMatriculaService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/matricula")
@AllArgsConstructor
public class MatriculaController {
    private final IMatriculaService matriculaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> findAll() {
        List<MatriculaDTO> list=mapperUtil.mapList(matriculaService.findAll(), MatriculaDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDTO> findById(@PathVariable("id") Integer id) {
        Matricula object=matriculaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, MatriculaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody MatriculaDTO dto) {
        Matricula obj=matriculaService.save(mapperUtil.map(dto,Matricula.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMatricula()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<MatriculaDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody MatriculaDTO dto) {
        dto.setIdMatricula(id);
        Matricula obj=matriculaService.update(id, mapperUtil.map(dto,Matricula.class));
        return ResponseEntity.ok(mapperUtil.map(obj, MatriculaDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        matriculaService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
