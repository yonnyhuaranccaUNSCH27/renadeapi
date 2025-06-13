package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.TipoidentidadDTO;
import ipd.renade.renadeapi.model.Tipoidentidad;
import ipd.renade.renadeapi.service.ITipoidentidadService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tipoidentidad")
@RequiredArgsConstructor
public class TipoidentidadController {

    private final ITipoidentidadService tipoidentidadService;
    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipoidentidadDTO>> findAll(){
        //List<TipoidentidadDTO> list = tipoidentidadService.findAll().stream().map(this::convertToDto).toList();//e -> convertoDto()
        List<TipoidentidadDTO> list=mapperUtil.mapList(tipoidentidadService.findAll(), TipoidentidadDTO.class);
        return ResponseEntity.ok(list);

        //return new ResponseEntity<>(list, HttpStatus.OK);
        //retur tipoidentidadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoidentidadDTO> findById(@PathVariable("id") Integer id){
        Tipoidentidad obj=tipoidentidadService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoidentidadDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipoidentidadDTO dto){
        //Tipoidentidad obj=tipoidentidadService.save(convertToEntity(dto));
        Tipoidentidad obj=tipoidentidadService.save(mapperUtil.map(dto, Tipoidentidad.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipoidentidad()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoidentidadDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipoidentidadDTO dto){
        dto.setIdTipoidentidad(id);
        //Tipoidentidad obj=tipoidentidadService.update(id,convertToEntity(dto));
        Tipoidentidad obj=tipoidentidadService.update(id,mapperUtil.map(dto, Tipoidentidad.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TipoidentidadDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        tipoidentidadService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*private TipoidentidadDTO convertToDto(Tipoidentidad obj){
        return modelMapper.map(obj,TipoidentidadDTO.class);
    }
    private Tipoidentidad convertToEntity(TipoidentidadDTO objDto){
        return modelMapper.map(objDto,Tipoidentidad.class);
    }*/

}
