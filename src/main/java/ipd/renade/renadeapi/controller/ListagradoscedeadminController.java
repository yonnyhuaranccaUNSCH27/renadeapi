package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.ListagradoscedeadminDTO;
import ipd.renade.renadeapi.model.Listagradoscedeadmin;
import ipd.renade.renadeapi.service.IListagradoscedeadminService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/listagradoscedeadmin")
@AllArgsConstructor
public class ListagradoscedeadminController {
    private final IListagradoscedeadminService listagradoscedeadminService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ListagradoscedeadminDTO>> findAll() {
        List<ListagradoscedeadminDTO> list=mapperUtil.mapList(listagradoscedeadminService.findAll(), ListagradoscedeadminDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ListagradoscedeadminDTO> findById(@PathVariable("id") Integer id) {
        Listagradoscedeadmin object=listagradoscedeadminService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, ListagradoscedeadminDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListagradoscedeadminDTO dto) {
        Listagradoscedeadmin obj=listagradoscedeadminService.save(mapperUtil.map(dto,Listagradoscedeadmin.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdListagradoscedeadmin()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<ListagradoscedeadminDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody ListagradoscedeadminDTO dto) {
        dto.setIdListagradoscedeadmin(id);
        Listagradoscedeadmin obj=listagradoscedeadminService.update(id, mapperUtil.map(dto,Listagradoscedeadmin.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ListagradoscedeadminDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        listagradoscedeadminService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
