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
@Table(name = "tbl_listadisciplina")
public class Listadisciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idListadisciplina;

    @ManyToOne
    @JoinColumn(name = "id_organizacion",foreignKey = @ForeignKey(name = "FK_LISTADISC_ORG"))
    private Organizacion organizacion;

    @ManyToOne
    @JoinColumn(name = "id_disciplina",foreignKey = @ForeignKey(name = "FK_LISTADISC_DISCIPLINA"))
    private Disciplina disciplina;
}
