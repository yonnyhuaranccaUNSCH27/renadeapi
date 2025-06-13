package ipd.renade.renadeapi.dto;

import ipd.renade.renadeapi.model.Usuariorol;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariorolDTO {
    private Integer idUsuariorol;

    @NotNull
    private Integer idRol;

    @NotNull
    private Integer idUsuario;



}
