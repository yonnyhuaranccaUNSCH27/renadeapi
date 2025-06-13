package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.MenurolDTO;
import ipd.renade.renadeapi.model.Menurol;
import ipd.renade.renadeapi.service.IMenuRolService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/menurol")
@AllArgsConstructor
public class MenurolController {
    private final IMenuRolService menurolService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<MenurolDTO>> findAll() {
        List<MenurolDTO> list=mapperUtil.mapList(menurolService.findAll(), MenurolDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MenurolDTO> findById(@PathVariable("id") Integer id) {
        Menurol object=menurolService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, MenurolDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody MenurolDTO dto) {
        Menurol obj=menurolService.save(mapperUtil.map(dto,Menurol.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMenurol()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<MenurolDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody MenurolDTO dto) {
        dto.setIdMenurol(id);
        Menurol obj=menurolService.update(id, mapperUtil.map(dto,Menurol.class));
        return ResponseEntity.ok(mapperUtil.map(obj, MenurolDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        menurolService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
