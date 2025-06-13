package ipd.renade.renadeapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CambioPasswordDTO {
    @NotNull
    private Integer idUsuario;

    @NotBlank
    private String passwordActual;

    @NotBlank
    private String passwordNueva;
}
