package ipd.renade.renadeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AfiliacionReqDTO {

    private Integer idAfiliacion;

    private Integer idOrganizacionAfiliadora;

    private Integer idOrganizacionAfiliada;

    private String observacion;

    private Integer estado;
}

