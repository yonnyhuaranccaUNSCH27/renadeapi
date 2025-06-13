package ipd.renade.renadeapi.dto;

import ipd.renade.renadeapi.model.Tipoidentidad;
import ipd.renade.renadeapi.model.Ubigeo;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    private Integer idPersona;

    @NotNull
    private String perNumdocumento;

    @NotNull
    private String perNombres;

    @NotNull
    private String apePaterno;

    @NotNull
    private String apeMaterna;

    //@NotNull
    private Integer perGenero;

    private String perDireccion;

    private String perTelefono;

    private String perCorreo;
    private LocalDate perFechanacimiento;

    private Integer idUbigeo;

    private UbigeoDTO ubigeo;

    private Integer idTipoidentidad;

    //@NotNull
    private TipoidentidadDTO tipoidentidad;
}
