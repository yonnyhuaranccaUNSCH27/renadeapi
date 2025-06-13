package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.OrganizacionPartidaDTO;
import ipd.renade.renadeapi.dto.PartidaelectronicaDTO;
import ipd.renade.renadeapi.model.Partidaelectronica;
import ipd.renade.renadeapi.service.IPartidaelectronicaService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/partida-electronica")
@AllArgsConstructor
public class PartidaelectronicaController {
    private final IPartidaelectronicaService partidaelectronicaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<PartidaelectronicaDTO>> findAll() {
        List<PartidaelectronicaDTO> list=mapperUtil.mapList(partidaelectronicaService.findAll(), PartidaelectronicaDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/ultimo/{partida}/inscripcion/{inscripcion}")
    public Integer obtenerUltimoOrden(@PathVariable("partida") String partida,@PathVariable("inscripcion") String inscripcion) {
        String orden=partidaelectronicaService.getUltimoOrden(partida,inscripcion);

        return Integer.parseInt(orden);
    }
    @GetMapping("/org-partida")
    public ResponseEntity<List<OrganizacionPartidaDTO>> getOrgPartida() {

        List<OrganizacionPartidaDTO> list=partidaelectronicaService.findOrganizacionesConPartidas();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/conteo")
    public long getTotalPartidas() {
        return partidaelectronicaService.totalPartidas();
    }

    @GetMapping("/sigla/{sigla}/codigo/{codigo}")
    public ResponseEntity<List<PartidaelectronicaDTO>> findBySigla(@PathVariable("sigla") String sigla,@PathVariable("codigo") String codigo) {
        List<PartidaelectronicaDTO> list=mapperUtil.mapList(partidaelectronicaService.findAllBySigla(sigla,codigo), PartidaelectronicaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidaelectronicaDTO> findById(@PathVariable("id") Integer id) {
        Partidaelectronica object=partidaelectronicaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, PartidaelectronicaDTO.class));
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PartidaelectronicaDTO dto) {
        Partidaelectronica obj=partidaelectronicaService.save(mapperUtil.map(dto,Partidaelectronica.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPartidaelectronica()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<PartidaelectronicaDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody PartidaelectronicaDTO dto) {
        dto.setIdPartidaelectronica(id);
        Partidaelectronica obj=partidaelectronicaService.update(id, mapperUtil.map(dto,Partidaelectronica.class));
        return ResponseEntity.ok(mapperUtil.map(obj, PartidaelectronicaDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        partidaelectronicaService.delete(id);
        return ResponseEntity.noContent().build();
    }



}