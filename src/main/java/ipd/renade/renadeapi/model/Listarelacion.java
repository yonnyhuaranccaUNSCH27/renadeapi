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
@Table(name = "tbl_listarelacion")
public class Listarelacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idListarelacion;

    @Column(nullable = false, length = 300)
    private String descripcion;
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "id_persona",foreignKey = @ForeignKey(name = "FK_LISTARELACION_PERSONA"))
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_disciplina",foreignKey = @ForeignKey(name = "FK_LISTARELACION_DISCIPLINA"))
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "id_inscripcionrenade",foreignKey = @ForeignKey(name = "FK_LISTARELACION_INSCRIP"))
    private Inscripcionrenade inscripcionrenade;
}
