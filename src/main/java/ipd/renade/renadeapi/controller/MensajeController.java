package ipd.renade.renadeapi.controller;


import ipd.renade.renadeapi.dto.MensajeDTO;
import ipd.renade.renadeapi.model.Mensaje;
import ipd.renade.renadeapi.model.Persona;
import ipd.renade.renadeapi.service.IMensajeService;
import ipd.renade.renadeapi.service.IPersonaService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/mensaje")
@AllArgsConstructor
public class MensajeController {
    private final IMensajeService mensajeService;
    private final IPersonaService personaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<MensajeDTO>> findAll() {
        List<MensajeDTO> list=mapperUtil.mapList(mensajeService.findAll(), MensajeDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MensajeDTO> findById(@PathVariable("id") Integer id) {
        Mensaje object=mensajeService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, MensajeDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody MensajeDTO dto) {

        Persona persona = mapperUtil.map(dto.getPersona(), Persona.class);

        if (persona.getIdPersona() == null) {
            // Persona nueva: guardar
            persona = personaService.save(persona);
        } else {
            // Persona existente: obtener datos actualizados
            persona = personaService.findById(persona.getIdPersona());
        }

        // Mapear mensaje y asignar persona persistida
        Mensaje mensaje = mapperUtil.map(dto, Mensaje.class);
        mensaje.setPersona(persona);

        Mensaje obj = mensajeService.save(mensaje);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdMensaje())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MensajeDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody MensajeDTO dto) {
        dto.setIdMensaje(id);
        Mensaje obj=mensajeService.update(id, mapperUtil.map(dto,Mensaje.class));
        return ResponseEntity.ok(mapperUtil.map(obj, MensajeDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        mensajeService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
