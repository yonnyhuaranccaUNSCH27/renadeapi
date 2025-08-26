package ipd.renade.renadeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmisionDTO {
    private Integer idAdmision;

    private String admisionname;
    private String description;
    private String modalidadinscripcion;
    private String localinscripcion;
    private String horarioentregadocumento;
    private Date finicioinscripcion;
    private Date ffinalinscripcion;
    private Date fresultadofinal;
    private Date finiciomatricula;
    private Date ffinalmatricula;

    private AnosDTO anos;
}
