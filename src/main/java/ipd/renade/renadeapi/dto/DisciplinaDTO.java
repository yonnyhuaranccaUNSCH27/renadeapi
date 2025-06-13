package ipd.renade.renadeapi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaDTO {
    private Integer idDisciplina;

    @NotNull
    private String codigo;

    @NotNull
    private String descripcion;
}
