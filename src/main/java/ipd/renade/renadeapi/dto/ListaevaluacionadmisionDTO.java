package ipd.renade.renadeapi.dto;

import ipd.renade.renadeapi.model.Admision;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaevaluacionadmisionDTO {
    private Integer idListaevaluacionadmision;

    private String description;
    private LocalDateTime finicio1;
    private LocalDateTime ffinal1;

    private LocalDateTime finicio2;
    private LocalDateTime ffinal2;

    private LocalDateTime finicio3;
    private LocalDateTime ffinal3;

    private LocalDateTime finicio4;
    private LocalDateTime ffinal4;

    private AdmisionDTO admision;
}
