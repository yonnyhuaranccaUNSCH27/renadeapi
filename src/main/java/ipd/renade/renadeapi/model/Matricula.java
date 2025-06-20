package ipd.renade.renadeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_matricula",
        schema = "cede")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMatricula;

    private String nombreorganizacion;
    private LocalDateTime fcompetencia;
    private LocalDateTime fregistro;

    @ManyToOne()
    @JoinColumn(name = "id_alumno", foreignKey = @ForeignKey(name = "FK_MATRICULA_ALUMNO"))
    private Alumno alumno;

    @ManyToOne()
    @JoinColumn(name = "id_merito", foreignKey = @ForeignKey(name = "FK_MATRICULA_MERITO"))
    private Merito merito;

    @ManyToOne()
    @JoinColumn(name = "id_categoria", foreignKey = @ForeignKey(name = "FK_MATRICULA_CATEGORIA"))
    private Categoria categoria;

    @ManyToOne()
    @JoinColumn(name = "id_disciplina", foreignKey = @ForeignKey(name = "FK_MATRICULA_DISCIPLINA"))
    private Disciplina disciplina;

    @ManyToOne()
    @JoinColumn(name = "id_anos", foreignKey = @ForeignKey(name = "FK_MATRICULA_ANOS"))
    private Anos anos;

    @ManyToOne()
    @JoinColumn(name = "id_modalidad", foreignKey = @ForeignKey(name = "FK_MATRICULA_MODALIDAD"))
    private Modalidad modalidad;

    @ManyToOne()
    @JoinColumn(name = "id_grado", foreignKey = @ForeignKey(name = "FK_MATRICULA_GRADO"))
    private Grado grado;
}
