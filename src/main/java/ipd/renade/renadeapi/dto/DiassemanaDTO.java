package ipd.renade.renadeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiassemanaDTO {
    private Integer idDiassemana;
    private String codigo;
    private String descripcion;
}
