package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.TipooficinaDTO;
import ipd.renade.renadeapi.model.Tipooficina;
import ipd.renade.renadeapi.service.ITipooficinaService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tipooficina")
@RequiredArgsConstructor
public class TipooficinaController {

    private final ITipooficinaService tipooficinaService;
    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipooficinaDTO>> findAll(){
        //List<TipooficinaDTO> list = tipooficinaService.findAll().stream().map(this::convertToDto).toList();//e -> convertoDto()
        List<TipooficinaDTO> list=mapperUtil.mapList(tipooficinaService.findAll(), TipooficinaDTO.class);
        return ResponseEntity.ok(list);

        //return new ResponseEntity<>(list, HttpStatus.OK);
        //retur tipooficinaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipooficinaDTO> findById(@PathVariable("id") Integer id){
        Tipooficina obj=tipooficinaService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, TipooficinaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipooficinaDTO dto){
        //Tipooficina obj=tipooficinaService.save(convertToEntity(dto));
        Tipooficina obj=tipooficinaService.save(mapperUtil.map(dto, Tipooficina.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipooficina()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipooficinaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipooficinaDTO dto){
        dto.setIdTipooficina(id);
        //Tipooficina obj=tipooficinaService.update(id,convertToEntity(dto));
        Tipooficina obj=tipooficinaService.update(id,mapperUtil.map(dto, Tipooficina.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TipooficinaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        tipooficinaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*private TipooficinaDTO convertToDto(Tipooficina obj){
        return modelMapper.map(obj,TipooficinaDTO.class);
    }
    private Tipooficina convertToEntity(TipooficinaDTO objDto){
        return modelMapper.map(objDto,Tipooficina.class);
    }*/

}
