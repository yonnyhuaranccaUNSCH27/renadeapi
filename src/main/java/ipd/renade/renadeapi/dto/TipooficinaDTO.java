package ipd.renade.renadeapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipooficinaDTO {

    private Integer idTipooficina;

    @NotNull
    private String descripcion;

}
