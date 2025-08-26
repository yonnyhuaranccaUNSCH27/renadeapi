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
@Table(name = "tbl_listagradoscedeadmin",
        schema = "cede")
public class Listagradoscedeadmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idListagradoscedeadmin;

    private String rangoedad;

    @ManyToOne()
    @JoinColumn(name = "id_admision", foreignKey = @ForeignKey(name = "FK_LISTAGRADOSCEDEADMISION_ADMISION"))
    private Admision admision;

    @ManyToOne()
    @JoinColumn(name = "id_grado", foreignKey = @ForeignKey(name = "FK_LISTAGRADOSCEDEADMISION_GRADO"))
    private Grado grado;
}
