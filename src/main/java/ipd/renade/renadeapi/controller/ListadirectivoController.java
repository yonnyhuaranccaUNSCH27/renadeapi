package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.DirectivodataDTO;
import ipd.renade.renadeapi.dto.DisciplinaDTO;
import ipd.renade.renadeapi.dto.ListadirectivoDTO;
import ipd.renade.renadeapi.dto.ListadirectivoDTO;
import ipd.renade.renadeapi.model.Disciplina;
import ipd.renade.renadeapi.model.Listadirectivo;
import ipd.renade.renadeapi.service.IListadirectivoService;
import ipd.renade.renadeapi.service.IListadirectivoService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/listadirectivo")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*") //para dar acceso a angular el puerto
public class ListadirectivoController {

    private final IListadirectivoService listadirectivoService;
    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ListadirectivoDTO>> findAll(){
        //List<ListadirectivoDTO> list = listadirectivoService.findAll().stream().map(this::convertToDto).toList();//e -> convertoDto()
        List<ListadirectivoDTO> list=mapperUtil.mapList(listadirectivoService.findAll(), ListadirectivoDTO.class);
        return ResponseEntity.ok(list);

        //return new ResponseEntity<>(list, HttpStatus.OK);
        //retur listadirectivoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListadirectivoDTO> findById(@PathVariable("id") Integer id){
        Listadirectivo obj = listadirectivoService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, ListadirectivoDTO.class));
    }

    @GetMapping("/organizacion/{id}")
    public ResponseEntity<List<ListadirectivoDTO>> findByIdOrganizacion(@PathVariable("id") Integer id){
        List<Listadirectivo> obj = listadirectivoService.findByIdOrganizacion(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.mapList(obj, ListadirectivoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListadirectivoDTO dto){
        //Listadirectivo obj=listadirectivoService.save(convertToEntity(dto));
        Listadirectivo obj=listadirectivoService.saveDirectivo(dto);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdListadirectivo()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListadirectivoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ListadirectivoDTO dto){
        dto.setIdListadirectivo(id);
        //Listadirectivo obj=listadirectivoService.update(id,convertToEntity(dto));
        //Listadirectivo obj=listadirectivoService.update(id,mapperUtil.map(dto, Listadirectivo.class));
        Listadirectivo obj=listadirectivoService.updateDirectivo(dto);
        return ResponseEntity.ok(mapperUtil.map(obj, ListadirectivoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        listadirectivoService.deleteDirectivo(id);
        return ResponseEntity.noContent().build();
    }
    /*private ListadirectivoDTO convertToDto(Listadirectivo obj){
        return modelMapper.map(obj,ListadirectivoDTO.class);
    }
    private Listadirectivo convertToEntity(ListadirectivoDTO objDto){
        return modelMapper.map(objDto,Listadirectivo.class);
    }*/

}
