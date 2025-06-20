package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.ListapadresDTO;
import ipd.renade.renadeapi.model.Listapadres;
import ipd.renade.renadeapi.service.IListapadresService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/listapadres")
@AllArgsConstructor
public class ListapadresController {
    private final IListapadresService listapadresService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ListapadresDTO>> findAll() {
        List<ListapadresDTO> list=mapperUtil.mapList(listapadresService.findAll(), ListapadresDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ListapadresDTO> findById(@PathVariable("id") Integer id) {
        Listapadres object=listapadresService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, ListapadresDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListapadresDTO dto) {
        Listapadres obj=listapadresService.save(mapperUtil.map(dto,Listapadres.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdListapadres()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<ListapadresDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody ListapadresDTO dto) {
        dto.setIdListapadres(id);
        Listapadres obj=listapadresService.update(id, mapperUtil.map(dto,Listapadres.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ListapadresDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        listapadresService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
