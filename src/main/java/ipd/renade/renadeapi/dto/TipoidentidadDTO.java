package ipd.renade.renadeapi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoidentidadDTO {

    private Integer idTipoidentidad;

    @NotNull
    @Size(min = 1, max = 2,message = "{codigo.size}")
    private String codigo;

    @NotNull
    @Size(min = 1, max = 40,message = "{descripcion.size}")
    private String descripcion;

}
