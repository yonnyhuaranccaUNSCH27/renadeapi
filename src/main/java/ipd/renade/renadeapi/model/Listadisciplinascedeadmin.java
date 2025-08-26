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
@Table(name = "tbl_listadisciplinascedeadmin",
        schema = "cede")
public class Listadisciplinascedeadmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idListadisciplinascedeadmin;

    @ManyToOne()
    @JoinColumn(name = "id_admision", foreignKey = @ForeignKey(name = "FK_LISTADISCIPLINAADMISION_ADMISION"))
    private Admision admision;

    @ManyToOne()
    @JoinColumn(name = "id_disciplina", foreignKey = @ForeignKey(name = "FK_LISTADISCIPLINAADMISION_DISCIPLINA"))
    private Disciplina disciplina;
}
