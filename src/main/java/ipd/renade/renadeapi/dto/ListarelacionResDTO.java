package ipd.renade.renadeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListarelacionResDTO {
    private Integer idListarelacion;
    private String descripcion;
    private Integer estado;
    private PersonaResDTO persona;
    private DisciplinaDTO disciplina;
}
