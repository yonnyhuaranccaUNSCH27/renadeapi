package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.NiveleducacionDTO;
import ipd.renade.renadeapi.model.Niveleducacion;
import ipd.renade.renadeapi.service.INiveleducacionService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/niveleducacion")
@AllArgsConstructor
public class NiveleducacionController {
    private final INiveleducacionService niveleducacionService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<NiveleducacionDTO>> findAll() {
        List<NiveleducacionDTO> list=mapperUtil.mapList(niveleducacionService.findAll(), NiveleducacionDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<NiveleducacionDTO> findById(@PathVariable("id") Integer id) {
        Niveleducacion object=niveleducacionService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, NiveleducacionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody NiveleducacionDTO dto) {
        Niveleducacion obj=niveleducacionService.save(mapperUtil.map(dto,Niveleducacion.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdNiveleducacion()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<NiveleducacionDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody NiveleducacionDTO dto) {
        dto.setIdNiveleducacion(id);
        Niveleducacion obj=niveleducacionService.update(id, mapperUtil.map(dto,Niveleducacion.class));
        return ResponseEntity.ok(mapperUtil.map(obj, NiveleducacionDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        niveleducacionService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
