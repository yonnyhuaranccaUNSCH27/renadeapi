package ipd.renade.renadeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorariosDTO {
    private Integer idHorarios;
    private LocalTime hinicio;
    private LocalTime hfinal;
    private DiassemanaDTO diassemana;
}
