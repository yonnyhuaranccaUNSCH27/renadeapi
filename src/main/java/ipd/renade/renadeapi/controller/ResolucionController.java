package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.ResolucionDTO;
import ipd.renade.renadeapi.dto.ResolucionNumeroDTO;
import ipd.renade.renadeapi.model.Resolucion;
import ipd.renade.renadeapi.service.IResolucionService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/resolucion")
@RequiredArgsConstructor
public class ResolucionController {

    private final IResolucionService resolucionService;

    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ResolucionDTO>> findAll(){
       List<ResolucionDTO> list=mapperUtil.mapList(resolucionService.findAll(), ResolucionDTO.class);
        return ResponseEntity.ok(list);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ResolucionDTO> findById(@PathVariable("id") Integer id){
        Resolucion obj=resolucionService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ResolucionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Integer> save(@Valid @RequestBody ResolucionDTO dto){
        Resolucion obj=resolucionService.save(mapperUtil.map(dto, Resolucion.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdResolucion()).toUri();
        return ResponseEntity.created(location).body(obj.getIdResolucion());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResolucionDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ResolucionDTO dto){
        dto.setIdResolucion(id);
        //Resolucion obj=resolucionService.update(id,convertToEntity(dto));
        Resolucion obj=resolucionService.update(id,mapperUtil.map(dto, Resolucion.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ResolucionDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        //resolucionService.delete(id);
        resolucionService.deleteResolucion(id);
        return ResponseEntity.noContent().build();
    }



    //Organizaciones
    @GetMapping("/organizacion/{id}")
    public ResponseEntity<List<ResolucionDTO>> findByIdOrganizacion(@PathVariable("id") Integer id){
        List<Resolucion> obj=resolucionService.findResolucionByOrganizacion(id);
        return ResponseEntity.ok(mapperUtil.mapList(obj, ResolucionDTO.class));
    }

    @GetMapping("/numero/organizacion/{id}")
    public ResponseEntity<List<ResolucionNumeroDTO>> findNroByIdOrganizacion(@PathVariable("id") Integer id){
        List<ResolucionNumeroDTO> dto=resolucionService.findResolucionNroByOrganizacion(id);
        return ResponseEntity.ok(dto); 
    }

    @PostMapping("/organizacion/{id}")
    public ResponseEntity<Void> saveOrganizacion(@PathVariable("id") Integer idOrganizacion, @Valid @RequestBody ResolucionDTO dto){
        //Resolucion obj=resolucionService.save(convertToEntity(dto));
        Resolucion obj=resolucionService.saveResolucionOrganizacion(idOrganizacion, mapperUtil.map(dto, Resolucion.class));
        //URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdResolucion()).toUri();
        return ResponseEntity.noContent().build();
    }
}
