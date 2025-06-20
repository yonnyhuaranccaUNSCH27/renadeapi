package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.GradoinstruccionDTO;
import ipd.renade.renadeapi.model.Gradoinstruccion;
import ipd.renade.renadeapi.service.IGradoinstruccionService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/gradoinstruccion")
@AllArgsConstructor
public class GradoinstruccionController {
    private final IGradoinstruccionService gradoinstruccionService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<GradoinstruccionDTO>> findAll() {
        List<GradoinstruccionDTO> list=mapperUtil.mapList(gradoinstruccionService.findAll(), GradoinstruccionDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GradoinstruccionDTO> findById(@PathVariable("id") Integer id) {
        Gradoinstruccion object=gradoinstruccionService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, GradoinstruccionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody GradoinstruccionDTO dto) {
        Gradoinstruccion obj=gradoinstruccionService.save(mapperUtil.map(dto,Gradoinstruccion.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdGradoinstruccion()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<GradoinstruccionDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody GradoinstruccionDTO dto) {
        dto.setIdGradoinstruccion(id);
        Gradoinstruccion obj=gradoinstruccionService.update(id, mapperUtil.map(dto,Gradoinstruccion.class));
        return ResponseEntity.ok(mapperUtil.map(obj, GradoinstruccionDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        gradoinstruccionService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
