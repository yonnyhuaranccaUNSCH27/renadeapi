package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.DocenteDTO;
import ipd.renade.renadeapi.model.Docente;
import ipd.renade.renadeapi.service.IDocenteService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/docente")
@AllArgsConstructor
public class DocenteController {
    private final IDocenteService docenteService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<DocenteDTO>> findAll() {
        List<DocenteDTO> list=mapperUtil.mapList(docenteService.findAll(), DocenteDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DocenteDTO> findById(@PathVariable("id") Integer id) {
        Docente object=docenteService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, DocenteDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody DocenteDTO dto) {
        Docente obj=docenteService.save(mapperUtil.map(dto,Docente.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdDocente()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<DocenteDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody DocenteDTO dto) {
        dto.setIdDocente(id);
        Docente obj=docenteService.update(id, mapperUtil.map(dto,Docente.class));
        return ResponseEntity.ok(mapperUtil.map(obj, DocenteDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        docenteService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
