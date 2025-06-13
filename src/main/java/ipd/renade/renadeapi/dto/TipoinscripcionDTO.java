package ipd.renade.renadeapi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoinscripcionDTO {

    private Integer idTipoinscripcion;

    @NotNull
    private String descripcion;
    private Integer estado;

}
