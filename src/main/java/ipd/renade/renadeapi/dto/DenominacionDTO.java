package ipd.renade.renadeapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DenominacionDTO {
    private Integer idDenominacion;

    @NotNull
    @Size(min = 1, max = 200,message = "{descripcion.size}")
    private String descripcion;

}
