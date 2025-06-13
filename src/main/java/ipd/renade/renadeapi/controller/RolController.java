package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.RolDTO;
import ipd.renade.renadeapi.model.Rol;
import ipd.renade.renadeapi.service.IRolService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/rol")
@AllArgsConstructor
public class RolController {
    private final IRolService rolService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<RolDTO>> findAll() {
        List<RolDTO> list=mapperUtil.mapList(rolService.findAll(), RolDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> findById(@PathVariable("id") Integer id) {
        Rol object=rolService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, RolDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody RolDTO dto) {
        Rol obj=rolService.save(mapperUtil.map(dto,Rol.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdRol()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody RolDTO dto) {
        dto.setIdRol(id);
        Rol obj=rolService.update(id, mapperUtil.map(dto,Rol.class));
        return ResponseEntity.ok(mapperUtil.map(obj, RolDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        rolService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
