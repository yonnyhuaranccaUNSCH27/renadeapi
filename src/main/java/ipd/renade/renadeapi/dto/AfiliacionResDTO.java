package ipd.renade.renadeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AfiliacionResDTO {

    private Integer idAfiliacion;

    private Integer idOrganizacionAfiliadora;

    private OrganizacionAfiliadoraDTO organizacionAfiliadora;

    private String observacion;

    private Integer estado;
}