package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.CompetenciaDTO;
import ipd.renade.renadeapi.model.Competencia;
import ipd.renade.renadeapi.service.ICompetenciaService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/competencia")
@AllArgsConstructor
public class CompetenciaController {
    private final ICompetenciaService competenciaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CompetenciaDTO>> findAll() {
        List<CompetenciaDTO> list=mapperUtil.mapList(competenciaService.findAll(), CompetenciaDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CompetenciaDTO> findById(@PathVariable("id") Integer id) {
        Competencia object=competenciaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, CompetenciaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CompetenciaDTO dto) {
        Competencia obj=competenciaService.save(mapperUtil.map(dto,Competencia.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCompetencia()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<CompetenciaDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody CompetenciaDTO dto) {
        dto.setIdCompetencia(id);
        Competencia obj=competenciaService.update(id, mapperUtil.map(dto,Competencia.class));
        return ResponseEntity.ok(mapperUtil.map(obj, CompetenciaDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        competenciaService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
