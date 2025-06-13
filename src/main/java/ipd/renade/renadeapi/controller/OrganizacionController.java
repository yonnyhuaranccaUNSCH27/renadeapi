package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.OrganizacionAfiliadoraDTO;
import ipd.renade.renadeapi.dto.OrganizacionDTO;
import ipd.renade.renadeapi.dto.OrganizacionResumenDTO;
import ipd.renade.renadeapi.dto.OrganizacionTablaDTO;
import ipd.renade.renadeapi.model.Organizacion;
import ipd.renade.renadeapi.service.IOrganizacionService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/organizacion")
@RequiredArgsConstructor
public class OrganizacionController {
    private final IOrganizacionService organizacionService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<OrganizacionDTO>> findAll(){
        List<OrganizacionDTO> list=mapperUtil.mapList(organizacionService.findAll(), OrganizacionDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizacionDTO> findById(@PathVariable("id") Integer id){
        Organizacion obj=organizacionService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, OrganizacionDTO.class));
    }

    @GetMapping("tipoorganizacion/{id}")
    public ResponseEntity<List<OrganizacionDTO>> findByTipoOrganizacion(@PathVariable("id") Integer id){
        List<OrganizacionDTO> list=mapperUtil.mapList(organizacionService.findByIdTipoOrganizacion(id), OrganizacionDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/conteo/tipo-organizacion")
    public Map<Integer, Long> findCountByTipoOrg() {
        return organizacionService.findCountByTipoOrg();
    }

    @GetMapping("/conteo/tipo-liga")
    public Map<Integer, Long> findCountByTipoLiga() {
        return organizacionService.findCountByTipoLiga();
    }

    @GetMapping("/afiliadora/{id}")
    public ResponseEntity<List<OrganizacionAfiliadoraDTO>> findAllOrgAfiliadora(@PathVariable("id") Integer idOrganizacion){
        return ResponseEntity.ok(organizacionService.findAllOrgAfiliadora(idOrganizacion));
    }

    @GetMapping("/tabla-tipo-org/{id}")
    public ResponseEntity<List<OrganizacionTablaDTO>> findAllTablaOrg(@PathVariable("id") Integer idTipoOrganizacion){
        return ResponseEntity.ok(organizacionService.getInfoOrgForTable(idTipoOrganizacion));
    }

    @GetMapping("/page-by-tipoorg/{id}")
    public ResponseEntity<Page<OrganizacionTablaDTO>> findPageByTipoOrg(@PathVariable("id") Integer idTipoOrganizacion, Pageable pageable ){
        return ResponseEntity.ok(organizacionService.findOrgByTipoForTable(idTipoOrganizacion, pageable));
    }

    @GetMapping("/resumen/{id}")
    public ResponseEntity<OrganizacionResumenDTO> findResumenOrg(@PathVariable("id") Integer idOrganizacion){
        return ResponseEntity.ok(organizacionService.findResumenOrgById(idOrganizacion));
    }

    @GetMapping("/codigo/{sigla}")
    public ResponseEntity<Map<String,String>> generarCodigo(@PathVariable("sigla") String sigla){
        return ResponseEntity.ok(organizacionService.generarCodigo(sigla));
    }

    @PostMapping
    public ResponseEntity<OrganizacionDTO> save(@Valid @RequestBody OrganizacionDTO dto){
        //dto.setIdTipoorganizacion(2);
        Organizacion obj=organizacionService.saveOrganizacion(mapperUtil.map(dto,Organizacion.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdOrganizacion()).toUri();
        //return ResponseEntity.created(location).build();
        return ResponseEntity.created(location).body(mapperUtil.map(obj, OrganizacionDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizacionDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody OrganizacionDTO dto){
        dto.setIdOrganizacion(id);
        Organizacion obj=organizacionService.updateOrganizacion(mapperUtil.map(dto, Organizacion.class));
        return ResponseEntity.ok(mapperUtil.map(obj, OrganizacionDTO.class));
    }

    @PutMapping("/deshabilitar/{id}")
    public ResponseEntity<Void> deshabilitar(@PathVariable("id") Integer id){
        organizacionService.deshabilitarOrganizacion(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        organizacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
