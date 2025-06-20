package ipd.renade.renadeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTO {
    private Integer idDocente;

    private String codigo;
    private Integer diasexperiencia;
    private Integer semanasexperiencia;
    private Integer mesesexperiencia;
    private Integer anosexperiencia;
    private String perfil;
    private String urlfoto;

    private PersonaDTO persona;

    private EspecialidadDTO especialidad;

    private GradoinstruccionDTO gradoinstruccion;

    private InstitucionDTO institucion;
}
