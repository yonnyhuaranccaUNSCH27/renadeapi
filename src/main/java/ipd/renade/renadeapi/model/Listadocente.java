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
@Table(name = "tbl_listadocente",
        schema = "cede")
public class Listadocente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idListadocente;

    @ManyToOne()
    @JoinColumn(name = "id_curso", foreignKey = @ForeignKey(name = "FK_LISTADOCENTE_CURSO"))
    private Curso curso;

    @ManyToOne()
    @JoinColumn(name = "id_docente", foreignKey = @ForeignKey(name = "FK_LISTADOCENTE_DOCENTE"))
    private Docente docente;

    @ManyToOne()
    @JoinColumn(name = "id_anos", foreignKey = @ForeignKey(name = "FK_LISTADOCENTE_ANOS"))
    private Anos anos;

}
