package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.MeritoDTO;
import ipd.renade.renadeapi.model.Merito;
import ipd.renade.renadeapi.service.IMeritoService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/merito")
@AllArgsConstructor
public class MeritoController {
    private final IMeritoService meritoService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<MeritoDTO>> findAll() {
        List<MeritoDTO> list=mapperUtil.mapList(meritoService.findAll(), MeritoDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MeritoDTO> findById(@PathVariable("id") Integer id) {
        Merito object=meritoService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, MeritoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody MeritoDTO dto) {
        Merito obj=meritoService.save(mapperUtil.map(dto,Merito.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMerito()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<MeritoDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody MeritoDTO dto) {
        dto.setIdMerito(id);
        Merito obj=meritoService.update(id, mapperUtil.map(dto,Merito.class));
        return ResponseEntity.ok(mapperUtil.map(obj, MeritoDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        meritoService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
