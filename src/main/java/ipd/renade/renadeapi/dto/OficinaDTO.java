package ipd.renade.renadeapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OficinaDTO {

    private Integer idOficina;

    @NotNull
    private String descripcion;

    @NotNull
    private Integer idTipooficina;

}

