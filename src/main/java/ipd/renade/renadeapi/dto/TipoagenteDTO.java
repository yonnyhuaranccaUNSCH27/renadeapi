package ipd.renade.renadeapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoagenteDTO {
    private Integer idTipoagente;

    @NotNull
    private String descripcion;

    @NotNull
    private Integer estado;
}
