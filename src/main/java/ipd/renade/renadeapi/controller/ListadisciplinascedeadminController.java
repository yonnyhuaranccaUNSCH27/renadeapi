package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.ListadisciplinascedeadminDTO;
import ipd.renade.renadeapi.model.Listadisciplinascedeadmin;
import ipd.renade.renadeapi.service.IListadisciplinascedeadminService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/listadisciplinascedeadmin")
@AllArgsConstructor
public class ListadisciplinascedeadminController {
    private final IListadisciplinascedeadminService listadisciplinascedeadminService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ListadisciplinascedeadminDTO>> findAll() {
        List<ListadisciplinascedeadminDTO> list=mapperUtil.mapList(listadisciplinascedeadminService.findAll(), ListadisciplinascedeadminDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ListadisciplinascedeadminDTO> findById(@PathVariable("id") Integer id) {
        Listadisciplinascedeadmin object=listadisciplinascedeadminService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, ListadisciplinascedeadminDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListadisciplinascedeadminDTO dto) {
        Listadisciplinascedeadmin obj=listadisciplinascedeadminService.save(mapperUtil.map(dto,Listadisciplinascedeadmin.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdListadisciplinascedeadmin()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<ListadisciplinascedeadminDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody ListadisciplinascedeadminDTO dto) {
        dto.setIdListadisciplinascedeadmin(id);
        Listadisciplinascedeadmin obj=listadisciplinascedeadminService.update(id, mapperUtil.map(dto,Listadisciplinascedeadmin.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ListadisciplinascedeadminDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        listadisciplinascedeadminService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
