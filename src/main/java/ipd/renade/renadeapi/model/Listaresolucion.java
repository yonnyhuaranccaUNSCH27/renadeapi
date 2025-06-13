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
@Table(name = "tbl_listaresolucion")
public class Listaresolucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idListaresolucion;

    @ManyToOne
    @JoinColumn(name = "id_resolucion",foreignKey = @ForeignKey(name = "FK_LISTARESOL_RESOLUCION"))
    private Resolucion resolucion;

    @ManyToOne
    @JoinColumn(name = "id_organizacion",foreignKey = @ForeignKey(name = "FK_LISTARESOL_ORGANIZACION"))
    private Organizacion organizacion;
}
