package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.GradoDTO;
import ipd.renade.renadeapi.model.Grado;
import ipd.renade.renadeapi.service.IGradoService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/grado")
@AllArgsConstructor
public class GradoController {
    private final IGradoService gradoService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<GradoDTO>> findAll() {
        List<GradoDTO> list=mapperUtil.mapList(gradoService.findAll(), GradoDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GradoDTO> findById(@PathVariable("id") Integer id) {
        Grado object=gradoService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, GradoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody GradoDTO dto) {
        Grado obj=gradoService.save(mapperUtil.map(dto,Grado.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdGrado()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<GradoDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody GradoDTO dto) {
        dto.setIdGrado(id);
        Grado obj=gradoService.update(id, mapperUtil.map(dto,Grado.class));
        return ResponseEntity.ok(mapperUtil.map(obj, GradoDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        gradoService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
