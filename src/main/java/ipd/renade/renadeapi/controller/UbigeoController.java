package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.UbigeoDTO;
import ipd.renade.renadeapi.model.Ubigeo;
import ipd.renade.renadeapi.service.IUbigeoService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ubigeo")
@AllArgsConstructor
public class UbigeoController {
    private final IUbigeoService ubigeoService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<UbigeoDTO>> findAll() {
        List<UbigeoDTO> list=mapperUtil.mapList(ubigeoService.findAll(), UbigeoDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/paises")
    public ResponseEntity<List<UbigeoDTO>> getCountries() {
        List<UbigeoDTO> countries = mapperUtil.mapList(ubigeoService.getAllCountries(), UbigeoDTO.class);
        return ResponseEntity.ok(countries);
    }
    @GetMapping("/departamentos")
    public ResponseEntity<List<UbigeoDTO>> getDepartments() {
        List<UbigeoDTO> departments = mapperUtil.mapList(ubigeoService.getDepartments(), UbigeoDTO.class);
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/provincias/{department}")
    public ResponseEntity<List<UbigeoDTO>> getProvincias(@PathVariable String department) {
        List<UbigeoDTO> provincias = mapperUtil.mapList(ubigeoService.getProviciasByDepartment(department),UbigeoDTO.class) ;
        return ResponseEntity.ok(provincias);
    }

    @GetMapping("/distritos")
    public ResponseEntity<List<UbigeoDTO>> getDistritos(
            @RequestParam String departamento,
            @RequestParam String provincia)  {
        List<UbigeoDTO> ubigeos = mapperUtil.mapList(ubigeoService.getDistritos(departamento, provincia),UbigeoDTO.class);
        return ResponseEntity.ok(ubigeos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UbigeoDTO> findById(@PathVariable("id") Integer id) {
        Ubigeo object=ubigeoService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, UbigeoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody UbigeoDTO dto) {
        Ubigeo obj=ubigeoService.save(mapperUtil.map(dto,Ubigeo.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUbigeo()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<UbigeoDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody UbigeoDTO dto) {
        dto.setIdUbigeo(id);
        Ubigeo obj=ubigeoService.update(id, mapperUtil.map(dto,Ubigeo.class));
        return ResponseEntity.ok(mapperUtil.map(obj, UbigeoDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        ubigeoService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
