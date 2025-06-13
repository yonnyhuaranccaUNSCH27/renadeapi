package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.InscripcionrenadeResDTO;
import ipd.renade.renadeapi.dto.ListapartidaelectronicaReqDTO;
import ipd.renade.renadeapi.dto.ListapartidaelectronicaResDTO;
import ipd.renade.renadeapi.model.Listapartidaelectronica;
import ipd.renade.renadeapi.service.IListapartidaelectronicaService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/lista-partida")
@AllArgsConstructor
public class ListapartidaController {
    private final IListapartidaelectronicaService listapartidaelectronicaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ListapartidaelectronicaResDTO>> findAll() {
        List<ListapartidaelectronicaResDTO> list=mapperUtil.mapList(listapartidaelectronicaService.findAll(), ListapartidaelectronicaResDTO.class);;
        return ResponseEntity.ok(list);
    }
    @GetMapping("/resolucion/{id}")
    public ResponseEntity<List<ListapartidaelectronicaResDTO>> findAllByRes(@PathVariable("id") Integer id) {
        List<ListapartidaelectronicaResDTO> list=listapartidaelectronicaService.findAllResumeByIDRes(id);
        System.out.println("list = " + list);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/organizacion/{id}")
    public ResponseEntity<List<ListapartidaelectronicaResDTO>> findAllByOrg(@PathVariable("id") Integer id) {
        List<ListapartidaelectronicaResDTO> list=listapartidaelectronicaService.findAllByIdOrg(id);
        System.out.println("list = " + list);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ListapartidaelectronicaResDTO> findById(@PathVariable("id") Integer id) {
        Listapartidaelectronica object=listapartidaelectronicaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, ListapartidaelectronicaResDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListapartidaelectronicaReqDTO dto) {
        Listapartidaelectronica obj=listapartidaelectronicaService.save(mapperUtil.map(dto,Listapartidaelectronica.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdListapartidaelectronica()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<ListapartidaelectronicaReqDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody ListapartidaelectronicaReqDTO dto) {
        dto.setIdListapartidaelectronica(id);
        Listapartidaelectronica obj=listapartidaelectronicaService.update(id, mapperUtil.map(dto,Listapartidaelectronica.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ListapartidaelectronicaReqDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        listapartidaelectronicaService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
