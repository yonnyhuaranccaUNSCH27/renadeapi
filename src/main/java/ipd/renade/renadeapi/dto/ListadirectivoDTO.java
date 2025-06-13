package ipd.renade.renadeapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ipd.renade.renadeapi.model.Directivo;
import ipd.renade.renadeapi.model.Organizacion;
import ipd.renade.renadeapi.model.Resolucion;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListadirectivoDTO {
    private Integer idListadirectivo;

    //@NotNull
    //private Integer idResolucion;

    private ResolucionNumeroDTO resolucion;
    //@NotNull
    private Integer idDirectivo;

    private Integer idOrganizacion;

    @JsonBackReference
    private OrganizacionDTO organizacion;

    private DirectivoDTO directivo;

}
