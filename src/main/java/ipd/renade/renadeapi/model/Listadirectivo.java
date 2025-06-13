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
@Table(name = "tbl_listadirectivo")
public class Listadirectivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idListadirectivo;

    @ManyToOne
    @JoinColumn(name = "id_resolucion",foreignKey = @ForeignKey(name = "FK_LISTADRECT_RES"))
    private Resolucion resolucion;

    @ManyToOne
    @JoinColumn(name = "id_organizacion",foreignKey = @ForeignKey(name = "FK_LISTADRECT_ORG"))
    private Organizacion organizacion;

    @ManyToOne
    @JoinColumn(name = "id_directivo",foreignKey = @ForeignKey(name = "FK_LISTADRECT_DIRECTIVO"))
    private Directivo directivo;
}
