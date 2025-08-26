package ipd.renade.renadeapi.dto;

import ipd.renade.renadeapi.model.Admision;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListarequisitosadmisionDTO {
    private Integer idListarequisitosadmision;

    private String description;

    private AdmisionDTO admision;
}
