package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.FuncionesDTO;
import ipd.renade.renadeapi.model.Funciones;
import ipd.renade.renadeapi.service.IFuncionesService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/funciones")
@RequiredArgsConstructor
public class FuncionesController {

    private final IFuncionesService funcionesService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<FuncionesDTO>> findAll(){
        List<FuncionesDTO> list=mapperUtil.mapList(funcionesService.findAll(), FuncionesDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionesDTO> findById(@PathVariable("id") Integer id){
        Funciones obj=funcionesService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, FuncionesDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody FuncionesDTO dto){
        Funciones obj=funcionesService.save(mapperUtil.map(dto, Funciones.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdFunciones()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionesDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody FuncionesDTO dto){
        dto.setIdFunciones(id);
        Funciones obj=funcionesService.update(id,mapperUtil.map(dto, Funciones.class));
        return ResponseEntity.ok(mapperUtil.map(obj, FuncionesDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        funcionesService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
