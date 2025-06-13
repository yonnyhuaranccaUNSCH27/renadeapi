package ipd.renade.renadeapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaresolucionReqDTO {
    private Integer idListaresolucion;

    @NotNull
    private Integer idResolucion;

    @NotNull
    private Integer idOrganizacion;


}
