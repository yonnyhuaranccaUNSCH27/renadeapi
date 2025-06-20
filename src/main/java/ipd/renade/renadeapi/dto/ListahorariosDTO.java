package ipd.renade.renadeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListahorariosDTO {
    private Integer idListahorarios;

    private HorariosDTO horarios;

    private CursoDTO curso;
}
