package ipd.renade.renadeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_apoderados",
        schema = "cede")
public class Apoderados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idApoderados;

    private String ocupacion;
    private String observacion;

    @ManyToOne()
    @JoinColumn(name = "id_tipoapoderado", foreignKey = @ForeignKey(name = "FK_APODERADOS_TIPOAPODERADO"))
    private Tipoapoderado tipoapoderado;

    @ManyToOne()
    @JoinColumn(name = "id_persona", foreignKey = @ForeignKey(name = "FK_APODERADOS_PERSONA"))
    private Persona persona;

    @ManyToOne()
    @JoinColumn(name = "id_gradoinstruccion", foreignKey = @ForeignKey(name = "FK_APODERADOS_GRADOINSTRUCCION"))
    private Gradoinstruccion gradoinstruccion;

    @OneToMany(mappedBy = "apoderados", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Listapadres> listapadres;

}
