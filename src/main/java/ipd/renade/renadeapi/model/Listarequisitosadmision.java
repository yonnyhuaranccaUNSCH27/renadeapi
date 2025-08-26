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
@Table(name = "tbl_listarequisitosadmision",
        schema = "cede")
public class Listarequisitosadmision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idListarequisitosadmision;

    private String description;

    @ManyToOne()
    @JoinColumn(name = "id_admision", foreignKey = @ForeignKey(name = "FK_LISTAREQUISITOSADMISION_ADMISION"))
    private Admision admision;
}
