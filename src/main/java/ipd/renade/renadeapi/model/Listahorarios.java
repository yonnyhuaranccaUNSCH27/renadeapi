package ipd.renade.renadeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_listahorarios",
        schema = "cede")
public class Listahorarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idListahorarios;

    @ManyToOne()
    @JoinColumn(name = "id_horarios", foreignKey = @ForeignKey(name = "FK_LISTAHORARIOS_HORARIOS"))
    private Horarios horarios;

    @ManyToOne()
    @JoinColumn(name = "id_curso", foreignKey = @ForeignKey(name = "FK_LISTAHORARIOS_CURSOS"))
    private Curso curso;

}
