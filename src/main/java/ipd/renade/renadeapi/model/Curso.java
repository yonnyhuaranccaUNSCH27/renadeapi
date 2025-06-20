package ipd.renade.renadeapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_curso",
        schema = "cede")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCurso;

    @Column(nullable = false)
    private String titulo;

    private String subtitulo;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFinal;

    @Column(nullable = false)
    private Integer duracionsemanas;

    @Column(nullable = false)
    private Integer duracionhoras;

    @Column(nullable = false)
    private Integer cupos;

    @Column(nullable = false)
    private Double costo;

    private Double costoremate;

    private Integer estado;

    @Column(nullable = false, length = 6000)  // Esto define el tamaño máximo en la base de datos
    @Size(max = 6000, message = "La descripción no puede tener más de 600 caracteres")  // Esto define la validación a nivel de aplicación
    private String descripcion;

    private String urlimagen;

    @ManyToOne
    @JoinColumn(name = "id_categoria", foreignKey = @ForeignKey(name = "FK_CURSO_CATEGORIA"))
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_grado", foreignKey = @ForeignKey(name = "FK_CURSO_GRADO"))
    private Grado grado;

    @ManyToOne
    @JoinColumn(name = "id_modalidad", foreignKey = @ForeignKey(name = "FK_CURSO_MODALIDAD"))
    private Modalidad modalidad;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Listadocente> listadocente;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Listahorarios> listahorarios;
}
