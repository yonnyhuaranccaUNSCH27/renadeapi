package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.ListarequisitosadmisionDTO;
import ipd.renade.renadeapi.model.Listarequisitosadmision;
import ipd.renade.renadeapi.service.IListarequisitosadmisionService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/listarequisitosadmision")
@AllArgsConstructor
public class ListarequisitosadmisionController {
    private final IListarequisitosadmisionService listarequisitosadmisionService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ListarequisitosadmisionDTO>> findAll() {
        List<ListarequisitosadmisionDTO> list=mapperUtil.mapList(listarequisitosadmisionService.findAll(), ListarequisitosadmisionDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ListarequisitosadmisionDTO> findById(@PathVariable("id") Integer id) {
        Listarequisitosadmision object=listarequisitosadmisionService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, ListarequisitosadmisionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListarequisitosadmisionDTO dto) {
        Listarequisitosadmision obj=listarequisitosadmisionService.save(mapperUtil.map(dto,Listarequisitosadmision.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdListarequisitosadmision()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<ListarequisitosadmisionDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody ListarequisitosadmisionDTO dto) {
        dto.setIdListarequisitosadmision(id);
        Listarequisitosadmision obj=listarequisitosadmisionService.update(id, mapperUtil.map(dto,Listarequisitosadmision.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ListarequisitosadmisionDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        listarequisitosadmisionService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
