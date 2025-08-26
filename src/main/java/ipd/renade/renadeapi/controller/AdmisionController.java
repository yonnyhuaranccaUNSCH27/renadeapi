package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.AdmisionDTO;
import ipd.renade.renadeapi.model.Admision;
import ipd.renade.renadeapi.service.IAdmisionService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/admision")
@AllArgsConstructor
public class AdmisionController {
    private final IAdmisionService admisionService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<AdmisionDTO>> findAll() {
        List<AdmisionDTO> list=mapperUtil.mapList(admisionService.findAll(), AdmisionDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AdmisionDTO> findById(@PathVariable("id") Integer id) {
        Admision object=admisionService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, AdmisionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody AdmisionDTO dto) {
        Admision obj=admisionService.save(mapperUtil.map(dto,Admision.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdAdmision()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<AdmisionDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody AdmisionDTO dto) {
        dto.setIdAdmision(id);
        Admision obj=admisionService.update(id, mapperUtil.map(dto,Admision.class));
        return ResponseEntity.ok(mapperUtil.map(obj, AdmisionDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        admisionService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
