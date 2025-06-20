package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.ModalidadDTO;
import ipd.renade.renadeapi.model.Modalidad;
import ipd.renade.renadeapi.service.IModalidadService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/modalidad")
@AllArgsConstructor
public class ModalidadController {
    private final IModalidadService modalidadService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ModalidadDTO>> findAll() {
        List<ModalidadDTO> list=mapperUtil.mapList(modalidadService.findAll(), ModalidadDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ModalidadDTO> findById(@PathVariable("id") Integer id) {
        Modalidad object=modalidadService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, ModalidadDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ModalidadDTO dto) {
        Modalidad obj=modalidadService.save(mapperUtil.map(dto,Modalidad.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdModalidad()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<ModalidadDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody ModalidadDTO dto) {
        dto.setIdModalidad(id);
        Modalidad obj=modalidadService.update(id, mapperUtil.map(dto,Modalidad.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ModalidadDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        modalidadService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
