package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.TipoagenteDTO;
import ipd.renade.renadeapi.model.Tipoagente;
import ipd.renade.renadeapi.service.ITipoagenteService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tipoagente")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*") //para dar acceso a angular el puerto
public class TipoagenteController {

    private final ITipoagenteService tipoagenteService;
    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipoagenteDTO>> findAll(){
        //List<TipoagenteDTO> list = tipoagenteService.findAll().stream().map(this::convertToDto).toList();//e -> convertoDto()
        List<TipoagenteDTO> list=mapperUtil.mapList(tipoagenteService.findAll(), TipoagenteDTO.class);
        return ResponseEntity.ok(list);

        //return new ResponseEntity<>(list, HttpStatus.OK);
        //retur tipoagenteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoagenteDTO> findById(@PathVariable("id") Integer id){
        Tipoagente obj=tipoagenteService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoagenteDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipoagenteDTO dto){
        //Tipoagente obj=tipoagenteService.save(convertToEntity(dto));
        Tipoagente obj=tipoagenteService.save(mapperUtil.map(dto, Tipoagente.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipoagente()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoagenteDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipoagenteDTO dto){
        dto.setIdTipoagente(id);
        //Tipoagente obj=tipoagenteService.update(id,convertToEntity(dto));
        Tipoagente obj=tipoagenteService.update(id,mapperUtil.map(dto, Tipoagente.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoagenteDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        tipoagenteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*private TipoagenteDTO convertToDto(Tipoagente obj){
        return modelMapper.map(obj,TipoagenteDTO.class);
    }
    private Tipoagente convertToEntity(TipoagenteDTO objDto){
        return modelMapper.map(objDto,Tipoagente.class);
    }*/

}
