package ipd.renade.renadeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListadocenteDTO {
    private Integer idListadocente;

    private CursoDTO curso;

    private DocenteDTO docente;

    private AnosDTO anos;
}
