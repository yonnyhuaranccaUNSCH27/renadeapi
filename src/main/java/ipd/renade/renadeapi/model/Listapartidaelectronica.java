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
@Table(name = "tbl_listapartidaelectronica")
public class Listapartidaelectronica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idListapartidaelectronica;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_resolucion",foreignKey = @ForeignKey(name = "FK_LISTAPELECTRONICA_RESOL"))
    private Resolucion resolucion;

    @ManyToOne
    @JoinColumn(name = "id_partidaelectronica",foreignKey = @ForeignKey(name = "FK_LISTAPELECTRONICA_PELECTRONICA"))
    private Partidaelectronica partidaelectronica;
}
