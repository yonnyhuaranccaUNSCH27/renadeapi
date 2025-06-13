package ipd.renade.renadeapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import ipd.renade.renadeapi.dto.PersonaDTO;
import ipd.renade.renadeapi.dto.PersonaDocumentoDTO;
import ipd.renade.renadeapi.model.Persona;
import ipd.renade.renadeapi.service.IPersonaService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/persona")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*") //para dar acceso a angular el puerto
public class PersonaController {

    private final IPersonaService personaService;
    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> findAll(){
        //List<PersonaDTO> list = personaService.findAll().stream().map(this::convertToDto).toList();//e -> convertoDto()
        List<PersonaDTO> list=mapperUtil.mapList(personaService.findAll(), PersonaDTO.class);
        return ResponseEntity.ok(list);

        //return new ResponseEntity<>(list, HttpStatus.OK);
        //retur personaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> findById(@PathVariable("id") Integer id){
        Persona obj=personaService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, PersonaDTO.class));
    }

    @GetMapping("/tipoidentidad/{id}")
    public ResponseEntity<List<PersonaDocumentoDTO>> findByTipoidentidad(@PathVariable("id") Integer id){
        List<PersonaDocumentoDTO> dto=personaService.findByIdTipoIdentidad(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Integer> save(@Valid @RequestBody PersonaDTO dto){
        //Persona obj=personaService.save(convertToEntity(dto));
        Persona obj=personaService.save(mapperUtil.map(dto, Persona.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPersona()).toUri();
        return ResponseEntity.created(location).body(obj.getIdPersona());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody PersonaDTO dto){
        dto.setIdPersona(id);
        //Persona obj=personaService.update(id,convertToEntity(dto));
        Persona obj=personaService.update(id,mapperUtil.map(dto, Persona.class));
        return ResponseEntity.ok(mapperUtil.map(obj, PersonaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        personaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*private PersonaDTO convertToDto(Persona obj){
        return modelMapper.map(obj,PersonaDTO.class);
    }
    private Persona convertToEntity(PersonaDTO objDto){
        return modelMapper.map(objDto,Persona.class);
    }*/

    @Operation(summary = "Obtiene persona por numero documento")
    @GetMapping("/searchxnumdoc")
    public ResponseEntity<List<PersonaDTO>> getxnumdoc(
            @RequestParam Integer tipodocumento,
            @RequestParam String numdocumento
    ) {
        List<PersonaDTO> persona = mapperUtil.mapList(personaService.getxmundoc(tipodocumento,numdocumento),PersonaDTO.class);
        return ResponseEntity.ok(persona);
    }

}
