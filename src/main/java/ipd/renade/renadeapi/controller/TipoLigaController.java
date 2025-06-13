package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.TipoligaDTO;
import ipd.renade.renadeapi.model.Tipoliga;
import ipd.renade.renadeapi.service.ITipoligaService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tipoliga")
@RequiredArgsConstructor
public class TipoLigaController {

    private final ITipoligaService tipoligaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipoligaDTO>> findAll(){
        List<TipoligaDTO> list=mapperUtil.mapList(tipoligaService.findAll(), TipoligaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoligaDTO> findById(@PathVariable("id") Integer id){
        Tipoliga obj=tipoligaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipoligaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipoligaDTO dto){
        Tipoliga obj=tipoligaService.save(mapperUtil.map(dto, Tipoliga.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipoliga()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoligaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipoligaDTO dto){
        dto.setIdTipoliga(id);
        Tipoliga obj=tipoligaService.update(id,mapperUtil.map(dto, Tipoliga.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoligaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        tipoligaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
