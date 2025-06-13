package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.DenominacionDTO;
import ipd.renade.renadeapi.model.Denominacion;
import ipd.renade.renadeapi.service.IDenominacionService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/denominacion")
@RequiredArgsConstructor
public class DenominacionController {

    private final IDenominacionService denominacionService;
    /*@Qualifier("DenominacionMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<DenominacionDTO>> findAll(){
        List<DenominacionDTO> list = mapperUtil.mapList(denominacionService.findAll(), DenominacionDTO.class);
        return ResponseEntity.ok(list);

        //return new ResponseEntity<>(list, HttpStatus.OK);
        //retur denominacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DenominacionDTO> findById(@PathVariable("id") Integer id){
        Denominacion obj=denominacionService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, DenominacionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody DenominacionDTO dto){
        Denominacion obj=denominacionService.save(mapperUtil.map(dto, Denominacion.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdDenominacion()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DenominacionDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody DenominacionDTO dto){
        dto.setIdDenominacion(id);
        Denominacion obj=denominacionService.update(id,mapperUtil.map(dto, Denominacion.class));
        return ResponseEntity.ok(mapperUtil.map(obj, DenominacionDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        denominacionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*private DenominacionDTO convertToDto(Denominacion obj){
        return modelMapper.map(obj,DenominacionDTO.class);
    }
    private Denominacion convertToEntity(DenominacionDTO objDto){
        return modelMapper.map(objDto,Denominacion.class);
    }*/

}
