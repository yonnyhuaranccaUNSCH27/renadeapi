package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.HorariosDTO;
import ipd.renade.renadeapi.model.Horarios;
import ipd.renade.renadeapi.service.IHorariosService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/horarios")
@AllArgsConstructor
public class HorariosController {
    private final IHorariosService horariosService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<HorariosDTO>> findAll() {
        List<HorariosDTO> list=mapperUtil.mapList(horariosService.findAll(), HorariosDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<HorariosDTO> findById(@PathVariable("id") Integer id) {
        Horarios object=horariosService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, HorariosDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody HorariosDTO dto) {
        Horarios obj=horariosService.save(mapperUtil.map(dto,Horarios.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdHorarios()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<HorariosDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody HorariosDTO dto) {
        dto.setIdHorarios(id);
        Horarios obj=horariosService.update(id, mapperUtil.map(dto,Horarios.class));
        return ResponseEntity.ok(mapperUtil.map(obj, HorariosDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        horariosService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
