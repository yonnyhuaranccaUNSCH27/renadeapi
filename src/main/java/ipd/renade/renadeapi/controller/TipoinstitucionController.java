package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.TipoinstitucionDTO;
import ipd.renade.renadeapi.model.Tipoinstitucion;
import ipd.renade.renadeapi.service.ITipoinstitucionService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tipoinstitucion")
@RequiredArgsConstructor
public class TipoinstitucionController {

    private final ITipoinstitucionService tipoinstitucionService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipoinstitucionDTO>> findAll(){
        List<TipoinstitucionDTO> list=mapperUtil.mapList(tipoinstitucionService.findAll(), TipoinstitucionDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoinstitucionDTO> findById(@PathVariable("id") Integer id){
        Tipoinstitucion obj=tipoinstitucionService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipoinstitucionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipoinstitucionDTO dto){
        Tipoinstitucion obj=tipoinstitucionService.save(mapperUtil.map(dto, Tipoinstitucion.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipoinstitucion()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoinstitucionDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipoinstitucionDTO dto){
        dto.setIdTipoinstitucion(id);
        Tipoinstitucion obj=tipoinstitucionService.update(id,mapperUtil.map(dto, Tipoinstitucion.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoinstitucionDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        tipoinstitucionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
