package ipd.renade.renadeapi.dto;

import ipd.renade.renadeapi.model.Tipoorganizacion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DenominaciondeportivoDTO {
    private Integer idDenominaciondeportivo;
    private String codigo;
    private String descDenominacion;
    private Integer idTipoorganizacion;

}
