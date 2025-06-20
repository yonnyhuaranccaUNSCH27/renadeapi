package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.ListahorariosDTO;
import ipd.renade.renadeapi.model.Listahorarios;
import ipd.renade.renadeapi.service.IListahorariosService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/listahorarios")
@AllArgsConstructor
public class ListahorariosController {
    private final IListahorariosService listahorariosService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ListahorariosDTO>> findAll() {
        List<ListahorariosDTO> list=mapperUtil.mapList(listahorariosService.findAll(), ListahorariosDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ListahorariosDTO> findById(@PathVariable("id") Integer id) {
        Listahorarios object=listahorariosService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, ListahorariosDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListahorariosDTO dto) {
        Listahorarios obj=listahorariosService.save(mapperUtil.map(dto,Listahorarios.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdListahorarios()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<ListahorariosDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody ListahorariosDTO dto) {
        dto.setIdListahorarios(id);
        Listahorarios obj=listahorariosService.update(id, mapperUtil.map(dto,Listahorarios.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ListahorariosDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        listahorariosService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
