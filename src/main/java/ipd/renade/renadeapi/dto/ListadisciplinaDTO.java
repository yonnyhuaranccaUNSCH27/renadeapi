package ipd.renade.renadeapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ipd.renade.renadeapi.model.Disciplina;
import ipd.renade.renadeapi.model.Organizacion;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListadisciplinaDTO {
    private Integer idListadisciplina;

    private Integer idOrganizacion;

    @NotNull
    private DisciplinaDTO disciplina;
}
