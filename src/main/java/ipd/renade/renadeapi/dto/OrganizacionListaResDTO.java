package ipd.renade.renadeapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizacionListaResDTO {

    private Integer idListaresolucion;

    @NotNull
    private OrganizacionDTO organizacion;

    //@NotNull
    private List<ResolucionDTO> resolucion;
}
