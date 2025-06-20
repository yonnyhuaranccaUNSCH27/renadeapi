package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.ApoderadosDTO;
import ipd.renade.renadeapi.model.Apoderados;
import ipd.renade.renadeapi.service.IApoderadosService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/apoderados")
@AllArgsConstructor
public class ApoderadosController {
    private final IApoderadosService apoderadosService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ApoderadosDTO>> findAll() {
        List<ApoderadosDTO> list=mapperUtil.mapList(apoderadosService.findAll(), ApoderadosDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApoderadosDTO> findById(@PathVariable("id") Integer id) {
        Apoderados object=apoderadosService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, ApoderadosDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ApoderadosDTO dto) {
        Apoderados obj=apoderadosService.save(mapperUtil.map(dto,Apoderados.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdApoderados()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<ApoderadosDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody ApoderadosDTO dto) {
        dto.setIdApoderados(id);
        Apoderados obj=apoderadosService.update(id, mapperUtil.map(dto,Apoderados.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ApoderadosDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        apoderadosService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
