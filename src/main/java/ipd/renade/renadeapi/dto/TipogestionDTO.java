package ipd.renade.renadeapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipogestionDTO {
    private Integer idTipogestion;
    private String descripcion;
}
