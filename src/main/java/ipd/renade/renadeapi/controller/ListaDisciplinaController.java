package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.ListadisciplinaDTO;
import ipd.renade.renadeapi.model.Listadisciplina;
import ipd.renade.renadeapi.service.IListadisciplinaService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/lista-disciplina")
@AllArgsConstructor
public class ListaDisciplinaController {
    private final IListadisciplinaService listadisciplinaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ListadisciplinaDTO>> findAll() {
        List<ListadisciplinaDTO> list=mapperUtil.mapList(listadisciplinaService.findAll(), ListadisciplinaDTO.class);;
        return ResponseEntity.ok(list);
    }
    @GetMapping("/organizacion/{id}")
    public ResponseEntity<List<ListadisciplinaDTO>> findAllByRes(@PathVariable("id") Integer id) {
        List<ListadisciplinaDTO> list=mapperUtil.mapList(listadisciplinaService.findAllByIdOrg(id), ListadisciplinaDTO.class) ;
        System.out.println("list = " + list);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ListadisciplinaDTO> findById(@PathVariable("id") Integer id) {
        Listadisciplina object=listadisciplinaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, ListadisciplinaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ListadisciplinaDTO dto) {
        Listadisciplina obj=listadisciplinaService.save(mapperUtil.map(dto,Listadisciplina.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdListadisciplina()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<ListadisciplinaDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody ListadisciplinaDTO dto) {
        dto.setIdListadisciplina(id);
        Listadisciplina obj=listadisciplinaService.update(id, mapperUtil.map(dto,Listadisciplina.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ListadisciplinaDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        listadisciplinaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
