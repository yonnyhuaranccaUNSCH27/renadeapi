package ipd.renade.renadeapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ipd.renade.renadeapi.model.Partidaelectronica;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizacionPartidaDTO {
    private String descDenominacion;
    private PartidaelectronicaDTO partidaElectronica;

    public OrganizacionPartidaDTO(String descDenominacion, Partidaelectronica partidaElectronica) {
        this.descDenominacion = descDenominacion;
        this.partidaElectronica = new PartidaelectronicaDTO(
        partidaElectronica.getIdPartidaelectronica(),
                partidaElectronica.getNumPartida(),
                partidaElectronica.getNumInscripcion(),
                partidaElectronica.getNumOrden(),
                partidaElectronica.getCodUbigeo(),
                partidaElectronica.getCodDisciplina()
                );

    }
}
