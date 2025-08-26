package ipd.renade.renadeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_listaevaluacionadmision",
        schema = "cede")
public class Listaevaluacionadmision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
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

    @ManyToOne()
    @JoinColumn(name = "id_admision", foreignKey = @ForeignKey(name = "FK_LISTAEVALUACIONADMISION_ADMISION"))
    private Admision admision;
}
