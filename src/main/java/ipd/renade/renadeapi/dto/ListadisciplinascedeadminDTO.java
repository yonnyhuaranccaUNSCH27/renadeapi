package ipd.renade.renadeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListadisciplinascedeadminDTO {
    private Integer idListadisciplinascedeadmin;

    private AdmisionDTO admision;

    private DisciplinaDTO disciplina;
}
