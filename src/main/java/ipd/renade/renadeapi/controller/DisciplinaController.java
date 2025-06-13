package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.DisciplinaDTO;
import ipd.renade.renadeapi.model.Disciplina;
import ipd.renade.renadeapi.service.IDisciplinaService;
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

@RestController
@RequestMapping("/api/disciplina")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*") //para dar acceso a angular el puerto
public class DisciplinaController {

    private final IDisciplinaService disciplinaService;

    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<DisciplinaDTO>> findAll(){
        List<DisciplinaDTO> list=mapperUtil.mapList(disciplinaService.findAll(), DisciplinaDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/pageable")
        public ResponseEntity<Page<DisciplinaDTO>> listPage(Pageable pageable) {
            Page<DisciplinaDTO> page=disciplinaService.listPage(pageable).map(e->
                    mapperUtil.map(e, DisciplinaDTO.class));
            return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> findById(@PathVariable("id") Integer id){
        Disciplina obj=disciplinaService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, DisciplinaDTO.class));
    }
    @GetMapping("/conteo/total")
    public long findCountDisciplinas() {
        return disciplinaService.totalDisciplinas();
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody DisciplinaDTO dto){
        //Disciplina obj=disciplinaService.save(convertToEntity(dto));
        Disciplina obj=disciplinaService.save(mapperUtil.map(dto, Disciplina.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdDisciplina()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody DisciplinaDTO dto){
        dto.setIdDisciplina(id);
        //Disciplina obj=disciplinaService.update(id,convertToEntity(dto));
        Disciplina obj=disciplinaService.update(id,mapperUtil.map(dto, Disciplina.class));
        return ResponseEntity.ok(mapperUtil.map(obj, DisciplinaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        disciplinaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*private DisciplinaDTO convertToDto(Disciplina obj){
        return modelMapper.map(obj,DisciplinaDTO.class);
    }
    private Disciplina convertToEntity(DisciplinaDTO objDto){
        return modelMapper.map(objDto,Disciplina.class);
    }*/

}
