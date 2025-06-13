package ipd.renade.renadeapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsociacionDTO {
    private Integer idAsociacion;
    private Integer idOrganizacion;
    private Integer idDenominaciondeportivo;
    @JsonBackReference
    private OrganizacionDTO organizacioin;
}
