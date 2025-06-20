package ipd.renade.renadeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_competencia",
        schema = "cede")
public class Competencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCompetencia;

    private String nombreorganizacion;
    private Date fcompetencia;
    private LocalDateTime fregistro;

    @ManyToOne()
    @JoinColumn(name = "id_alumno", foreignKey = @ForeignKey(name = "FK_COMPETENCIA_ALUMNO"))
    private Alumno alumno;

    @ManyToOne()
    @JoinColumn(name = "id_merito", foreignKey = @ForeignKey(name = "FK_COMPETENCIA_MERITO"))
    private Merito merito;

    @ManyToOne()
    @JoinColumn(name = "id_categoria", foreignKey = @ForeignKey(name = "FK_COMPETENCIA_CATEGORIA"))
    private Categoria categoria;

    @ManyToOne()
    @JoinColumn(name = "id_disciplina", foreignKey = @ForeignKey(name = "FK_COMPETENCIA_DISCIPLINA"))
    private Disciplina disciplina;

    @ManyToOne()
    @JoinColumn(name = "id_modalidad", foreignKey = @ForeignKey(name = "FK_COMPETENCIA_MODALIDAD"))
    private Modalidad modalidad ;

    @ManyToOne()
    @JoinColumn(name = "id_grado", foreignKey = @ForeignKey(name = "FK_COMPETENCIA_GRADO"))
    private Grado grado;

    @ManyToOne()
    @JoinColumn(name = "id_seccion", foreignKey = @ForeignKey(name = "FK_COMPETENCIA_SECCION"))
    private Seccion seccion;

    @ManyToOne()
    @JoinColumn(name = "id_anos", foreignKey = @ForeignKey(name = "FK_COMPETENCIA_ANOS"))
    private Anos anos;
}
