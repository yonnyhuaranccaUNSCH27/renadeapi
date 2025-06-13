package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.TipogestionDTO;
import ipd.renade.renadeapi.model.Tipogestion;
import ipd.renade.renadeapi.service.ITipogestionService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tipogestion")
@RequiredArgsConstructor
public class TipogestionController {

    private final ITipogestionService tipogestionService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipogestionDTO>> findAll(){
        List<TipogestionDTO> list=mapperUtil.mapList(tipogestionService.findAll(), TipogestionDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipogestionDTO> findById(@PathVariable("id") Integer id){
        Tipogestion obj=tipogestionService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipogestionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipogestionDTO dto){
        Tipogestion obj=tipogestionService.save(mapperUtil.map(dto, Tipogestion.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipogestion()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipogestionDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipogestionDTO dto){
        dto.setIdTipogestion(id);
        Tipogestion obj=tipogestionService.update(id,mapperUtil.map(dto, Tipogestion.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TipogestionDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        tipogestionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
