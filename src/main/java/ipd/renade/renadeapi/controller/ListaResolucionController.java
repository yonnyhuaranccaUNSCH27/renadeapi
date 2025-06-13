package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.ListaresolucionDTO;
import ipd.renade.renadeapi.dto.ListaresolucionReqDTO;
import ipd.renade.renadeapi.dto.ResolucionDTO;
import ipd.renade.renadeapi.model.Listaresolucion;
import ipd.renade.renadeapi.model.Resolucion;
import ipd.renade.renadeapi.service.IListaresolucionService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lista-resolucion")
@RequiredArgsConstructor
public class ListaResolucionController {

    private final IListaresolucionService listaresolucionService;

    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ListaresolucionDTO>> findAll(){
        List<ListaresolucionDTO> list=mapperUtil.mapList(listaresolucionService.findAll(), ListaresolucionDTO.class);
        return ResponseEntity.ok(list);

    }

    @GetMapping("/organizacion/{id}")
    public ResponseEntity<List<ListaresolucionDTO>> findAllByOrg(@PathVariable("id") Integer id){
        List<ListaresolucionDTO> list=mapperUtil.mapList(listaresolucionService.findAllByIdOrg(id), ListaresolucionDTO.class);
        return ResponseEntity.ok(list);

    }
    @GetMapping("/conteo/tipo-organizacion")
    public Map<Integer, Long> findCountByTipoOrg() {
        return listaresolucionService.findCountByTipoOrg();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ListaresolucionDTO> findById(@PathVariable("id") Integer id){
        Listaresolucion obj=listaresolucionService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ListaresolucionDTO.class));
    }


    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListaresolucionReqDTO dto){
        Listaresolucion obj=listaresolucionService.save(mapperUtil.map(dto,Listaresolucion.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getResolucion().getIdResolucion()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ListaresolucionDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ListaresolucionDTO dto){
        dto.setIdListaresolucion(id);
        //Resolucion obj=listaresolucionService.update(id,convertToEntity(dto));
        Listaresolucion obj=listaresolucionService.update(id,mapperUtil.map(dto,Listaresolucion.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ListaresolucionDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        listaresolucionService.delete(id);
        return ResponseEntity.noContent().build();
    }



}