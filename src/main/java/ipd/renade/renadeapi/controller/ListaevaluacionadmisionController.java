package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.ListaevaluacionadmisionDTO;
import ipd.renade.renadeapi.model.Listaevaluacionadmision;
import ipd.renade.renadeapi.service.IListaevaluacionadmisionService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/listaevaluacionadmision")
@AllArgsConstructor
public class ListaevaluacionadmisionController {
    private final IListaevaluacionadmisionService listaevaluacionadmisionService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ListaevaluacionadmisionDTO>> findAll() {
        List<ListaevaluacionadmisionDTO> list=mapperUtil.mapList(listaevaluacionadmisionService.findAll(), ListaevaluacionadmisionDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ListaevaluacionadmisionDTO> findById(@PathVariable("id") Integer id) {
        Listaevaluacionadmision object=listaevaluacionadmisionService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, ListaevaluacionadmisionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListaevaluacionadmisionDTO dto) {
        Listaevaluacionadmision obj=listaevaluacionadmisionService.save(mapperUtil.map(dto,Listaevaluacionadmision.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdListaevaluacionadmision()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<ListaevaluacionadmisionDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody ListaevaluacionadmisionDTO dto) {
        dto.setIdListaevaluacionadmision(id);
        Listaevaluacionadmision obj=listaevaluacionadmisionService.update(id, mapperUtil.map(dto,Listaevaluacionadmision.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ListaevaluacionadmisionDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        listaevaluacionadmisionService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
