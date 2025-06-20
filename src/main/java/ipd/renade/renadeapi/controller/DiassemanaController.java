package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.DiassemanaDTO;
import ipd.renade.renadeapi.model.Diassemana;
import ipd.renade.renadeapi.service.IDiassemanaService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/diassemana")
@AllArgsConstructor
public class DiassemanaController {
    private final IDiassemanaService diassemanaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<DiassemanaDTO>> findAll() {
        List<DiassemanaDTO> list=mapperUtil.mapList(diassemanaService.findAll(), DiassemanaDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DiassemanaDTO> findById(@PathVariable("id") Integer id) {
        Diassemana object=diassemanaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, DiassemanaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody DiassemanaDTO dto) {
        Diassemana obj=diassemanaService.save(mapperUtil.map(dto,Diassemana.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdDiassemana()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<DiassemanaDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody DiassemanaDTO dto) {
        dto.setIdDiassemana(id);
        Diassemana obj=diassemanaService.update(id, mapperUtil.map(dto,Diassemana.class));
        return ResponseEntity.ok(mapperUtil.map(obj, DiassemanaDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        diassemanaService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
