package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.TipoapoderadoDTO;
import ipd.renade.renadeapi.model.Tipoapoderado;
import ipd.renade.renadeapi.service.ITipoapoderadoService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tipoapoderado")
@AllArgsConstructor
public class TipoapoderadoController {
    private final ITipoapoderadoService tipoapoderadoService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipoapoderadoDTO>> findAll() {
        List<TipoapoderadoDTO> list=mapperUtil.mapList(tipoapoderadoService.findAll(), TipoapoderadoDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipoapoderadoDTO> findById(@PathVariable("id") Integer id) {
        Tipoapoderado object=tipoapoderadoService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, TipoapoderadoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipoapoderadoDTO dto) {
        Tipoapoderado obj=tipoapoderadoService.save(mapperUtil.map(dto,Tipoapoderado.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipoapoderado()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<TipoapoderadoDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody TipoapoderadoDTO dto) {
        dto.setIdTipoapoderado(id);
        Tipoapoderado obj=tipoapoderadoService.update(id, mapperUtil.map(dto,Tipoapoderado.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoapoderadoDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        tipoapoderadoService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
