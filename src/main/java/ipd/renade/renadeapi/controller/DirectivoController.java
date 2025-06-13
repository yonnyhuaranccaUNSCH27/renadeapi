package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.DirectivoDTO;
import ipd.renade.renadeapi.model.Directivo;
import ipd.renade.renadeapi.service.IDirectivoService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/directivo")
@RequiredArgsConstructor
public class DirectivoController {
    private final IDirectivoService directivoService;
    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<DirectivoDTO>> findAll(){
        //List<DirectivoDTO> list = directivoService.findAll().stream().map(this::convertToDto).toList();//e -> convertoDto()
        List<DirectivoDTO> list=mapperUtil.mapList(directivoService.findAll(), DirectivoDTO.class);
        return ResponseEntity.ok(list);

        //return new ResponseEntity<>(list, HttpStatus.OK);
        //retur directivoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectivoDTO> findById(@PathVariable("id") Integer id){
        Directivo obj=directivoService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, DirectivoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody DirectivoDTO dto){
        //Directivo obj=directivoService.save(convertToEntity(dto));
        Directivo obj=directivoService.save(mapperUtil.map(dto, Directivo.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdDirectivo()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DirectivoDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody DirectivoDTO dto){
        dto.setIdDirectivo(id);
        //Directivo obj=directivoService.update(id,convertToEntity(dto));
        Directivo obj=directivoService.update(id,mapperUtil.map(dto, Directivo.class));
        return ResponseEntity.ok(mapperUtil.map(obj, DirectivoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        directivoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
