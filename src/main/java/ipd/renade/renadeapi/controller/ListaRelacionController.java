package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.ListarelacionDTO;
import ipd.renade.renadeapi.dto.ListarelacionResDTO;
import ipd.renade.renadeapi.dto.ListarelacionapiDTO;
import ipd.renade.renadeapi.model.Inscripcionrenade;
import ipd.renade.renadeapi.model.Listarelacion;
import ipd.renade.renadeapi.model.Persona;
import ipd.renade.renadeapi.model.Resolucion;
import ipd.renade.renadeapi.projection.ListarelacionProjection;
import ipd.renade.renadeapi.repository.IListarelacionRepository;
import ipd.renade.renadeapi.service.IListarelacionService;
import ipd.renade.renadeapi.service.IPersonaService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/listarelacion")
@RequiredArgsConstructor
public class ListaRelacionController {

    private final IListarelacionService listarelacionService;
    private final MapperUtil mapperUtil;
    private final IPersonaService personaService;

    @GetMapping
    public ResponseEntity<List<ListarelacionResDTO>> findAll() {
        List<ListarelacionResDTO> list=mapperUtil.mapList(listarelacionService.findAll(), ListarelacionResDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("listainscripcion")
    public ResponseEntity<List<ListarelacionapiDTO>> findAllapi() {
        List<ListarelacionapiDTO> list=mapperUtil.mapList(listarelacionService.findAlldeportistas(), ListarelacionapiDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("inscripcion/{id}")
    public ResponseEntity<List<ListarelacionResDTO>> findByIdInscricpion(@PathVariable("id") Integer id){
        List<ListarelacionResDTO> list=mapperUtil.mapList(listarelacionService.findAllByIdInscripcion(id), ListarelacionResDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ListarelacionDTO> findById(@PathVariable("id") Integer id){
        Listarelacion obj=listarelacionService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ListarelacionDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListarelacionDTO dto){
        Listarelacion obj = listarelacionService.saveListaRelacionPersona(
                mapperUtil.map(dto, Listarelacion.class),mapperUtil.map(dto.getPersona(), Persona.class));

        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(obj.getIdListarelacion()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListarelacionDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ListarelacionDTO dto){
        dto.setIdListarelacion(id);
        Listarelacion lr=mapperUtil.map(dto, Listarelacion.class);
        System.out.println("lr = " + lr);
        System.out.println("lr.getPersona() = " + lr.getPersona());
        personaService.update(lr.getPersona().getIdPersona(),lr.getPersona());
        Listarelacion obj=listarelacionService.update(id,lr);

        return ResponseEntity.ok(mapperUtil.map(obj, ListarelacionDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        listarelacionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/conteo")
    public long getTotalDeportistas() {
        return listarelacionService.totalDep();
    }


}
