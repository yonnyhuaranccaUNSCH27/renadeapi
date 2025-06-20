package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.CategoriaDTO;
import ipd.renade.renadeapi.model.Categoria;
import ipd.renade.renadeapi.service.ICategoriaService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categoria")
@AllArgsConstructor
public class CategoriaController {
    private final ICategoriaService categoriaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<CategoriaDTO> list=mapperUtil.mapList(categoriaService.findAll(), CategoriaDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable("id") Integer id) {
        Categoria object=categoriaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, CategoriaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CategoriaDTO dto) {
        Categoria obj=categoriaService.save(mapperUtil.map(dto,Categoria.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCategoria()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody CategoriaDTO dto) {
        dto.setIdCategoria(id);
        Categoria obj=categoriaService.update(id, mapperUtil.map(dto,Categoria.class));
        return ResponseEntity.ok(mapperUtil.map(obj, CategoriaDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
