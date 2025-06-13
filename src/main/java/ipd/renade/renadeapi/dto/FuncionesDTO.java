package ipd.renade.renadeapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionesDTO {
    private Integer idFunciones;

    @NotNull
    @Size(min = 1, max = 120,message = "escribir funciones de 1 a 120 cartacteres")
    private String descripcion;

}
