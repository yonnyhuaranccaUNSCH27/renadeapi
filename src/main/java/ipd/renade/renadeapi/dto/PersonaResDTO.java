package ipd.renade.renadeapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaResDTO {
    private Integer idPersona;

    @NotNull
    private String perNumdocumento;

    @NotNull
    private String perNombres;

    @NotNull
    private String apePaterno;

    @NotNull
    private String apeMaterna;

    @NotNull
    private Integer perGenero;

    private String perDireccion;

    private String perTelefono;

    private String perCorreo;
    private String perFechanacimiento;


    private UbigeoDTO ubigeo;

    @NotNull
    private Integer idTipoidentidad;
}
