package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.UsuariorolDTO;
import ipd.renade.renadeapi.model.Usuariorol;
import ipd.renade.renadeapi.service.IUsuariorolService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuariorol")
@AllArgsConstructor
public class UsuariorolController {
    private final IUsuariorolService usuariorolService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<UsuariorolDTO>> findAll() {
        List<UsuariorolDTO> list=mapperUtil.mapList(usuariorolService.findAll(), UsuariorolDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuariorolDTO> findById(@PathVariable("id") Integer id) {
        Usuariorol object=usuariorolService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, UsuariorolDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody UsuariorolDTO dto) {
        Usuariorol obj=usuariorolService.save(mapperUtil.map(dto,Usuariorol.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUsuariorol()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuariorolDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody UsuariorolDTO dto) {
        dto.setIdUsuariorol(id);
        Usuariorol obj=usuariorolService.update(id, mapperUtil.map(dto,Usuariorol.class));
        return ResponseEntity.ok(mapperUtil.map(obj, UsuariorolDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        usuariorolService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
