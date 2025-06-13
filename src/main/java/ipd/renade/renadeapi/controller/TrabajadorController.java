package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.dto.PersonaDTO;
import ipd.renade.renadeapi.dto.TrabajadorDTO;
import ipd.renade.renadeapi.model.Persona;
import ipd.renade.renadeapi.model.Trabajador;
import ipd.renade.renadeapi.service.ITrabajadorService;
import ipd.renade.renadeapi.service.impl.PersonaServiceImpl;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/trabajador")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*") //para dar acceso a angular el puerto
public class TrabajadorController {

    private final ITrabajadorService trabajadorService;
    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;
    private final PersonaServiceImpl personaServiceImpl;

    @GetMapping
    public ResponseEntity<List<TrabajadorDTO>> findAll(){
        //List<TrabajadorDTO> list = trabajadorService.findAll().stream().map(this::convertToDto).toList();//e -> convertoDto()
        List<TrabajadorDTO> list=mapperUtil.mapList(trabajadorService.findAll(), TrabajadorDTO.class);
        return ResponseEntity.ok(list);

        //return new ResponseEntity<>(list, HttpStatus.OK);
        //retur trabajadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabajadorDTO> findById(@PathVariable("id") Integer id){
        Trabajador obj=trabajadorService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, TrabajadorDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TrabajadorDTO dto){

        // Guardamos primero la persona y obtenemos el idPersona generado
        Persona persona = mapperUtil.map(dto.getPersona(), Persona.class);
        Persona savedPersona = personaServiceImpl.save(persona);

        // 2. Asignamos el idPersona al TrabajadorDTO
        dto.getPersona().setIdPersona(savedPersona.getIdPersona());

        // 3. Guardar el Trabajador con el idPersona
        Trabajador trabajador = mapperUtil.map(dto, Trabajador.class);
        Trabajador savedTrabajador = trabajadorService.save(trabajador);

        // 4. Crear la URI de la respuesta
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTrabajador.getIdTrabajador())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrabajadorDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TrabajadorDTO dto){
        dto.setIdTrabajador(id);
        //Trabajador obj=trabajadorService.update(id,convertToEntity(dto));
        Trabajador obj=trabajadorService.update(id,mapperUtil.map(dto, Trabajador.class));
        return ResponseEntity.ok(mapperUtil.map(obj, TrabajadorDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        trabajadorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*private TrabajadorDTO convertToDto(Trabajador obj){
        return modelMapper.map(obj,TrabajadorDTO.class);
    }
    private Trabajador convertToEntity(TrabajadorDTO objDto){
        return modelMapper.map(objDto,Trabajador.class);
    }*/

}
