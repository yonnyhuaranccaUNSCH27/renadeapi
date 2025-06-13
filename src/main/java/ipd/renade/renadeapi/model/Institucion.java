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
@Table(name = "tbl_institucion")
public class Institucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idInstitucion;
    private String numdocumento;
    private String codigo;
    private String descripcion;
    private String direccion;
    private String telefono;
    private String correo;

    @Column(length = 4020)
    private String urlFilefoto;

    @ManyToOne
    @JoinColumn(name = "id_tipoinstitucion",foreignKey = @ForeignKey(name = "FK_INSTITUCION_TIPOINSTITUCION"))
    private Tipoinstitucion tipoinstitucion;

    @ManyToOne
    @JoinColumn(name = "id_Tipogestion",foreignKey = @ForeignKey(name = "FK_INSTITUCION_TIPOGESTION"))
    private Tipogestion tipogestion;

    @ManyToOne
    @JoinColumn(name = "id_ubigeo",foreignKey = @ForeignKey(name = "FK_INSTITUCION_UBIGEO"))
    private Ubigeo ubigeo;

    @ManyToOne
    @JoinColumn(name = "id_tipoidentidad",foreignKey = @ForeignKey(name = "FK_INSTITUCION_TIPOIDENTIDAD"))
    private Tipoidentidad tipoidentidad;

}
