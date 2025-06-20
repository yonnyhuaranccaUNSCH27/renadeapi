package ipd.renade.renadeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradoDTO {
    private Integer idGrado;
    private String descripcion;
    private NiveleducacionDTO niveleducacion;
}
