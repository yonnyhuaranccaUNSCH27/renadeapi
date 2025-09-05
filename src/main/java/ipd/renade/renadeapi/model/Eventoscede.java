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
@Table(name = "tbl_eventoscede",
        schema = "cede")
public class Eventoscede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEventoscede;
    private LocalDateTime fechainicio;
    private LocalDateTime fechafinal;
    private String titulo;


    @ManyToOne()
    @JoinColumn(name = "id_categoria", foreignKey = @ForeignKey(name = "FK_EVENTOSCEDE_CATEGORIA"))
    private Categoria categoria;

    private String localidad;
    private String organizador;
    private String duracion;
    private String observacion;

    @ManyToOne()
    @JoinColumn(name = "id_disciplina", foreignKey = @ForeignKey(name = "FK_EVENTOSCEDE_disciplina"))
    private Disciplina disciplina;

    private Integer estado;
}
