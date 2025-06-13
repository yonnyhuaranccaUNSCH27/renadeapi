package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.TipoinscripcionDTO;
import ipd.renade.renadeapi.model.Tipoinscripcion;
import ipd.renade.renadeapi.service.ITipoinscripcionService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tipoinscripcion")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*") //para dar acceso a angular el puerto
public class TipoinscripcionController {

    private final ITipoinscripcionService tipoinscripcionService;
    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipoinscripcionDTO>> findAll(){
        //List<TipoinscripcionDTO> list = tipoinscripcionService.findAll().stream().map(this::convertToDto).toList();//e -> convertoDto()
        List<TipoinscripcionDTO> list=mapperUtil.mapList(tipoinscripcionService.findAll(), TipoinscripcionDTO.class);
        return ResponseEntity.ok(list);

        //return new ResponseEntity<>(list, HttpStatus.OK);
        //retur tipoinscripcionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoinscripcionDTO> findById(@PathVariable("id") Integer id){
        Tipoinscripcion obj=tipoinscripcionService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoinscripcionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipoinscripcionDTO dto){
        //Tipoinscripcion obj=tipoinscripcionService.save(convertToEntity(dto));
        Tipoinscripcion obj=tipoinscripcionService.save(mapperUtil.map(dto, Tipoinscripcion.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipoinscripcion()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoinscripcionDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipoinscripcionDTO dto){
        dto.setIdTipoinscripcion(id);
        //Tipoinscripcion obj=tipoinscripcionService.update(id,convertToEntity(dto));
        Tipoinscripcion obj=tipoinscripcionService.update(id,mapperUtil.map(dto, Tipoinscripcion.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoinscripcionDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        tipoinscripcionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*private TipoinscripcionDTO convertToDto(Tipoinscripcion obj){
        return modelMapper.map(obj,TipoinscripcionDTO.class);
    }
    private Tipoinscripcion convertToEntity(TipoinscripcionDTO objDto){
        return modelMapper.map(objDto,Tipoinscripcion.class);
    }*/

}
