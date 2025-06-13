package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.AfiliacionReqDTO;
import ipd.renade.renadeapi.dto.AfiliacionResDTO;
import ipd.renade.renadeapi.model.Afiliacion;
import ipd.renade.renadeapi.service.IAfiliacionService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/afiliacion")
@RequiredArgsConstructor
public class AfiliacionController {

    private final IAfiliacionService afiliacionService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<AfiliacionResDTO>> findAll(){
        List<AfiliacionResDTO> list=mapperUtil.mapList(afiliacionService.findAll(), AfiliacionResDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AfiliacionResDTO> findById(@PathVariable("id") Integer id){
        Afiliacion obj=afiliacionService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, AfiliacionResDTO.class));
    }

    @GetMapping("/organizacion/{id}")
    public ResponseEntity<List<AfiliacionResDTO>> findByOrganizacion(@PathVariable("id") Integer id){
        List<Afiliacion> obj=afiliacionService.findByOrgAfiliada(id);
        return ResponseEntity.ok(mapperUtil.mapList(obj, AfiliacionResDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody AfiliacionReqDTO dto){
        Afiliacion obj=afiliacionService.save(mapperUtil.map(dto, Afiliacion.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdAfiliacion())
                .toUri();


        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AfiliacionResDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody AfiliacionReqDTO dto){
        dto.setIdAfiliacion(id);
        Afiliacion obj=afiliacionService.update(id,mapperUtil.map(dto, Afiliacion.class));
        return ResponseEntity.ok(mapperUtil.map(obj, AfiliacionResDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        afiliacionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}