package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.InscripcionrenadeDTO;
import ipd.renade.renadeapi.dto.InscripcionrenadeResDTO;
import ipd.renade.renadeapi.dto.OrganizacionAndInscripcionDTO;
import ipd.renade.renadeapi.model.Inscripcionrenade;
import ipd.renade.renadeapi.model.Resolucion;
import ipd.renade.renadeapi.service.IInscripcionrenadeService;
import ipd.renade.renadeapi.service.IResolucionService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.module.ResolutionException;
import java.net.URI;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/inscripcionrenade")
@RequiredArgsConstructor
public class InscripcionrenadeController {

    private final IInscripcionrenadeService inscripcionrenadeService;
    private final IResolucionService resolucionService;
    private final MapperUtil mapperUtil;

//    @GetMapping
//    public ResponseEntity<List<InscripcionrenadeResDTO>> findAll(){
//        List<InscripcionrenadeResDTO> list=mapperUtil.mapList(inscripcionrenadeService.findAllActivos(), InscripcionrenadeResDTO.class);
//        return ResponseEntity.ok(list);
//    }

    @GetMapping("/org-insc")
    public ResponseEntity<List<OrganizacionAndInscripcionDTO>> findAllOrgAndInsc(){
        List<OrganizacionAndInscripcionDTO> list=inscripcionrenadeService.getOrgsAndInsc();
        return ResponseEntity.ok(list);
    }
    //Implementacion con paginacion
    @GetMapping("/pageable")
    public ResponseEntity<Page<InscripcionrenadeResDTO>> listPage(Pageable pageable) {
        Page<InscripcionrenadeResDTO> page=inscripcionrenadeService.listPage(pageable).map(e->
                mapperUtil.map(e, InscripcionrenadeResDTO.class));
        return ResponseEntity.ok(page);
    }
    @GetMapping("/ultimo/{sigla}")
    public Integer obtenerUltimoCodigo(@PathVariable("sigla") String sigla) {
        String orden=inscripcionrenadeService.getUltimoCodigo(sigla);
        return Integer.parseInt(orden);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscripcionrenadeResDTO> findById(@PathVariable("id") Integer id){
        Inscripcionrenade obj=inscripcionrenadeService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, InscripcionrenadeResDTO.class));
    }

    @GetMapping("/conteo/tipo-inscripcion")
    public Map<Integer, Long> findCountByTipoInsc() {
        return inscripcionrenadeService.findCountByTipoInsc();
    }
    @GetMapping("/conteo/total")
    public long findCountInscripciones() {
        return inscripcionrenadeService.totalInscripciones();
    }

    @PostMapping
    public ResponseEntity<Integer> save(@Valid @RequestBody InscripcionrenadeDTO dto){
        // Mapeo de DTO a entidades
        Inscripcionrenade inscripcion = mapperUtil.map(dto, Inscripcionrenade.class);
        Resolucion resolucion = mapperUtil.map(dto.getResolucion(), Resolucion.class);
        // Guardar inscripción y resolución
        Inscripcionrenade obj = inscripcionrenadeService.saveinscirpcionresolucion(inscripcion, resolucion);

        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdInscripcionrenade()).toUri();
        return ResponseEntity.created(location).body(obj.getIdInscripcionrenade());
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscripcionrenadeResDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody InscripcionrenadeDTO dto){
        dto.setIdInscripcionrenade(id);
        Inscripcionrenade inscripcion = mapperUtil.map(dto, Inscripcionrenade.class);
        //para actualziar la persona
        resolucionService.update(inscripcion.getResolucion().getIdResolucion(),inscripcion.getResolucion());
        Inscripcionrenade obj=inscripcionrenadeService.update(id,inscripcion);
        return ResponseEntity.ok(mapperUtil.map(obj, InscripcionrenadeResDTO.class));
    }
    @PutMapping("/{id}/desactivar")
    public boolean desactivarEntidad(@PathVariable Integer id) {
        return  inscripcionrenadeService.desactivarInscripcionrenade(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        inscripcionrenadeService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/hateoas/{id}")
    public EntityModel<InscripcionrenadeDTO> findByIdHateoas(@PathVariable("id") Integer id) {
        Inscripcionrenade inscripcion = inscripcionrenadeService.findById(id);
        if (inscripcion == null) {
            throw new ResolutionException("Inscripción no encontrada con ID: " + id);
        }

        InscripcionrenadeDTO dto = mapperUtil.map(inscripcion, InscripcionrenadeDTO.class);

        EntityModel<InscripcionrenadeDTO> resource = EntityModel.of(dto);

        // Generar links
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).findById(id));
        resource.add(link1.withRel("oficina-self-info"));

        // Obtener el id de resolución desde el DTO
        Integer resolucionId = dto.getResolucion() != null ? dto.getResolucion().getIdResolucion() : null;
        if (resolucionId != null) {
            WebMvcLinkBuilder link2 = linkTo(methodOn(ResolucionController.class).findById(resolucionId));
            resource.add(link2.withRel("resolucion-id"));
        }

        return resource;
    }



}