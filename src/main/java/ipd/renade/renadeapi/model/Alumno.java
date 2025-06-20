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
@Table(name = "tbl_alumno",
        schema = "cede")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idAlumno;
    private String codigo;
    private String urlfoto;

    @ManyToOne()
    @JoinColumn(name = "id_persona", foreignKey = @ForeignKey(name = "FK_ALUMNO_PERSONA"))
    private Persona persona;
}
