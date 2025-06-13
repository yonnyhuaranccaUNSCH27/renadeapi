package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.TiporesolucionDTO;
import ipd.renade.renadeapi.model.Tiporesolucion;
import ipd.renade.renadeapi.service.ITiporesolucionService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tiporesolucion")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*") //para dar acceso a angular el puerto
public class TiporesolucionController {

    private final ITiporesolucionService tiporesolucionService;
    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TiporesolucionDTO>> findAll(){
        //List<TiporesolucionDTO> list = tiporesolucionService.findAll().stream().map(this::convertToDto).toList();//e -> convertoDto()
        List<TiporesolucionDTO> list=mapperUtil.mapList(tiporesolucionService.findAll(), TiporesolucionDTO.class);
        return ResponseEntity.ok(list);

        //return new ResponseEntity<>(list, HttpStatus.OK);
        //retur tiporesolucionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiporesolucionDTO> findById(@PathVariable("id") Integer id){
        Tiporesolucion obj=tiporesolucionService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, TiporesolucionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TiporesolucionDTO dto){
        //Tiporesolucion obj=tiporesolucionService.save(convertToEntity(dto));
        Tiporesolucion obj=tiporesolucionService.save(mapperUtil.map(dto, Tiporesolucion.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTiporesolucion()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TiporesolucionDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TiporesolucionDTO dto){
        dto.setIdTiporesolucion(id);
        //Tiporesolucion obj=tiporesolucionService.update(id,convertToEntity(dto));
        Tiporesolucion obj=tiporesolucionService.update(id,mapperUtil.map(dto, Tiporesolucion.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TiporesolucionDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        tiporesolucionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*private TiporesolucionDTO convertToDto(Tiporesolucion obj){
        return modelMapper.map(obj,TiporesolucionDTO.class);
    }
    private Tiporesolucion convertToEntity(TiporesolucionDTO objDto){
        return modelMapper.map(objDto,Tiporesolucion.class);
    }*/

}
