package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.TipotrabajadorDTO;
import ipd.renade.renadeapi.model.Tipotrabajador;
import ipd.renade.renadeapi.service.ITipotrabajadorService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tipotrabajador")
@RequiredArgsConstructor
public class TipotrabajadorController {

    private final ITipotrabajadorService tipotrabajadorService;
    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipotrabajadorDTO>> findAll(){
        //List<TipotrabajadorDTO> list = tipotrabajadorService.findAll().stream().map(this::convertToDto).toList();//e -> convertoDto()
        List<TipotrabajadorDTO> list=mapperUtil.mapList(tipotrabajadorService.findAll(), TipotrabajadorDTO.class);
        return ResponseEntity.ok(list);

        //return new ResponseEntity<>(list, HttpStatus.OK);
        //retur tipotrabajadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipotrabajadorDTO> findById(@PathVariable("id") Integer id){
        Tipotrabajador obj=tipotrabajadorService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, TipotrabajadorDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipotrabajadorDTO dto){
        //Tipotrabajador obj=tipotrabajadorService.save(convertToEntity(dto));
        Tipotrabajador obj=tipotrabajadorService.save(mapperUtil.map(dto, Tipotrabajador.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipotrabajador()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipotrabajadorDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipotrabajadorDTO dto){
        dto.setIdTipotrabajador(id);
        //Tipotrabajador obj=tipotrabajadorService.update(id,convertToEntity(dto));
        Tipotrabajador obj=tipotrabajadorService.update(id,mapperUtil.map(dto, Tipotrabajador.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TipotrabajadorDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        tipotrabajadorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*private TipotrabajadorDTO convertToDto(Tipotrabajador obj){
        return modelMapper.map(obj,TipotrabajadorDTO.class);
    }
    private Tipotrabajador convertToEntity(TipotrabajadorDTO objDto){
        return modelMapper.map(objDto,Tipotrabajador.class);
    }*/

}
