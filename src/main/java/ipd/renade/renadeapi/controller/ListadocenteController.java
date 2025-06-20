package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.ListadocenteDTO;
import ipd.renade.renadeapi.model.Listadocente;
import ipd.renade.renadeapi.service.IListadocenteService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/listadocente")
@AllArgsConstructor
public class ListadocenteController {
    private final IListadocenteService listadocenteService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ListadocenteDTO>> findAll() {
        List<ListadocenteDTO> list=mapperUtil.mapList(listadocenteService.findAll(), ListadocenteDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ListadocenteDTO> findById(@PathVariable("id") Integer id) {
        Listadocente object=listadocenteService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, ListadocenteDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListadocenteDTO dto) {
        Listadocente obj=listadocenteService.save(mapperUtil.map(dto,Listadocente.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdListadocente()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<ListadocenteDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody ListadocenteDTO dto) {
        dto.setIdListadocente(id);
        Listadocente obj=listadocenteService.update(id, mapperUtil.map(dto,Listadocente.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ListadocenteDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        listadocenteService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
