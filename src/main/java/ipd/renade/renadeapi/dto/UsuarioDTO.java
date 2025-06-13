package ipd.renade.renadeapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Integer idUsuario;

    @NotNull
    private String usernombres;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private Integer isActive;

    @NotNull
    private String email;

    private String urlFilefoto;
    private Integer termino1;
    private Integer termino2;

    @NotNull
    private LocalDateTime fechaRegistro;

    @NotNull
    private Integer idTrabajador;
    private Integer idTipousuario;

    private List<UsuariorolDTO> usuarioRoles;
}
