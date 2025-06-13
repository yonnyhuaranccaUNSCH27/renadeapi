package ipd.renade.renadeapi.controller;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import io.swagger.v3.oas.annotations.Operation;
import ipd.renade.renadeapi.dto.CambioPasswordDTO;
import ipd.renade.renadeapi.dto.UsuarioDTO;
import ipd.renade.renadeapi.model.Usuario;
import ipd.renade.renadeapi.service.IUsuarioService;
import ipd.renade.renadeapi.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.cloudinary.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor
public class UsuarioController {
    private final IUsuarioService usuarioService;
    private final MapperUtil mapperUtil;
    private final Cloudinary cloudinary;

    @PreAuthorize("@authorizeLogic.hasAccess('findAll')")
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> list=mapperUtil.mapList(usuarioService.findAll(), UsuarioDTO.class);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable("id") Integer id) {
        Usuario object=usuarioService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(object, UsuarioDTO.class));
    }
    @GetMapping("/username/{username}")
    public ResponseEntity<UsuarioDTO> findByUser(@PathVariable("username") String username) {
        Usuario object=usuarioService.findByUsername(username);
        return ResponseEntity.ok(mapperUtil.map(object, UsuarioDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody UsuarioDTO dto) {
        Usuario obj=usuarioService.save(mapperUtil.map(dto,Usuario.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUsuario()).toUri();
        return ResponseEntity.created(location).build();

    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody UsuarioDTO dto) {
        dto.setIdUsuario(id);
        Usuario obj=usuarioService.update(id, mapperUtil.map(dto,Usuario.class));
        return ResponseEntity.ok(mapperUtil.map(obj, UsuarioDTO.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/cambiar-password")
    public ResponseEntity<Map<String, Object>> cambiarPassword(@Valid @RequestBody CambioPasswordDTO dto) {
        Map<String, Object> response = new HashMap<>();

        boolean cambioExitoso = usuarioService.cambiarPassword(
                dto.getIdUsuario(),
                dto.getPasswordActual(),
                dto.getPasswordNueva()
        );

        if (cambioExitoso) {
            response.put("mensaje", "Contraseña actualizada correctamente");
            return ResponseEntity.ok(response);
        } else {
            response.put("mensaje", "La contraseña actual es incorrecta");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    //envia y devuelve url del imagen de cloudinary
    @PostMapping(value = "/saveFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, String>> saveFile(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        File f = this.convertToFile(multipartFile);
        Map<String, Object> response = cloudinary.uploader().upload(f, ObjectUtils.asMap("resource_type", "auto"));
        JSONObject json = new JSONObject(response);
        String url = json.getString("url");
        // Eliminar archivo temporal
        f.delete();

        // Preparar respuesta
        Map<String, String> result = new HashMap<>();
        result.put("url", url);

        return ResponseEntity.ok(result);
    }


    private File convertToFile(MultipartFile multipartFile) throws Exception{
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream outputStream= new FileOutputStream(file);
        outputStream.write(multipartFile.getBytes());
        outputStream.close();
        return file;
    }



}
