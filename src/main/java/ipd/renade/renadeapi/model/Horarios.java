package ipd.renade.renadeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_horarios",
        schema = "cede")
public class Horarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idHorarios;
    
    private LocalTime hinicio;
    private LocalTime hfinal;

    @ManyToOne()
    @JoinColumn(name = "id_diassemana", foreignKey = @ForeignKey(name = "FK_HORARIOS_DIASSEMANA"))
    private Diassemana diassemana;

}
