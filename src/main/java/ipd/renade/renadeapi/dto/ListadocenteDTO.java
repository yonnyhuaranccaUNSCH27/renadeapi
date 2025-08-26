package ipd.renade.renadeapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListadocenteDTO {
    private Integer idListadocente;

    @JsonIgnoreProperties({"listadocente", "listahorarios"})
    private CursoDTO curso;

    private DocenteDTO docente;

    private AnosDTO anos;
}
