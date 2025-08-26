package ipd.renade.renadeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_admision",
        schema = "cede")
public class Admision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idAdmision;

    private String admisionname;
    private String description;
    private String modalidadinscripcion;
    private String localinscripcion;
    private String horarioentregadocumento;
    private Date finicioinscripcion;
    private Date ffinalinscripcion;
    private Date fresultadofinal;
    private Date finiciomatricula;
    private Date ffinalmatricula;

    @ManyToOne()
    @JoinColumn(name = "id_anos", foreignKey = @ForeignKey(name = "FK_ADMISION_ANOS"))
    private Anos anos;
}
