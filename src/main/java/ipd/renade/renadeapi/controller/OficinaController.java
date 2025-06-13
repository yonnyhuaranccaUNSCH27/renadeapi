package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.OficinaDTO;
import ipd.renade.renadeapi.model.Oficina;
import ipd.renade.renadeapi.service.IOficinaService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/oficina")
@RequiredArgsConstructor
public class OficinaController {

    private final IOficinaService oficinaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<OficinaDTO>> findAll(){
        List<OficinaDTO> list=mapperUtil.mapList(oficinaService.findAll(), OficinaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OficinaDTO> findById(@PathVariable("id") Integer id){
        Oficina obj=oficinaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, OficinaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody OficinaDTO dto){
        Oficina obj=oficinaService.save(mapperUtil.map(dto, Oficina.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdOficina()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OficinaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody OficinaDTO dto){
        dto.setIdOficina(id);
        Oficina obj=oficinaService.update(id,mapperUtil.map(dto, Oficina.class));
        return ResponseEntity.ok(mapperUtil.map(obj, OficinaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        oficinaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<OficinaDTO> findByIdHateoas(@PathVariable("id") Integer id){
        EntityModel<OficinaDTO> resource=EntityModel.of(mapperUtil.map(oficinaService.findById(id), OficinaDTO.class));

        //generar link informacion
        WebMvcLinkBuilder link1=linkTo(methodOn(this.getClass()).findById(id));
        WebMvcLinkBuilder link2=linkTo(methodOn(TipooficinaController.class).findAll());

        resource.add(link1.withRel("oficina-self-info"));
        resource.add(link2.withRel("all-tipooficina-info"));

        return resource;
    }


}
