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
@Table(name = "tbl_docente",
        schema = "cede")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDocente;

    private String codigo;
    private Integer diasexperiencia;
    private Integer semanasexperiencia;
    private Integer mesesexperiencia;
    private Integer anosexperiencia;
    private String perfil;
    private String urlfoto;

    @ManyToOne()
    @JoinColumn(name = "id_persona", foreignKey = @ForeignKey(name = "FK_DOCENTE_PERSONA"))
    private Persona persona;

    @ManyToOne()
    @JoinColumn(name = "id_especialidad", foreignKey = @ForeignKey(name = "FK_DOCENTE_ESPECIALIDAD"))
    private Especialidad especialidad;

    @ManyToOne()
    @JoinColumn(name = "id_gradoinstruccion", foreignKey = @ForeignKey(name = "FK_DOCENTE_GRADOINSTRUCCION"))
    private Gradoinstruccion gradoinstruccion;

    @ManyToOne()
    @JoinColumn(name = "id_institucion", foreignKey = @ForeignKey(name = "FK_DOCENTE_INSTITUCION"))
    private Institucion institucion;
}
