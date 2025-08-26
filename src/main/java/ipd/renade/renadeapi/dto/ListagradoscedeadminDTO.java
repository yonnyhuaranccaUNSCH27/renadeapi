package ipd.renade.renadeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListagradoscedeadminDTO {
    private Integer idListagradoscedeadmin;

    private String rangoedad;

    private AdmisionDTO admision;

    private GradoDTO grado;
}
