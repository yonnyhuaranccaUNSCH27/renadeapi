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
@Table(name = "tbl_inscripcionrenade")
public class Inscripcionrenade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idInscripcionrenade;

    @Column(nullable = false, length = 300)
    private String motivo;
    private String sigla;
    private String codigo;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String observacion;
    @Column(nullable = false, columnDefinition = "bit default 1")
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_ubigeo",foreignKey = @ForeignKey(name = "FK_INSCRRENADE_UBIGEO"))
    private Ubigeo ubigeo;

    @ManyToOne()
    @JoinColumn(name = "id_tipoinscripcion", foreignKey = @ForeignKey(name = "FK_INSCRRENADE_TIPOINSC"))
    private Tipoinscripcion tipoinscripcion;

    @ManyToOne
    @JoinColumn(name = "id_resolucion",foreignKey = @ForeignKey(name = "FK_INSCRRENADE_RES"))
    private Resolucion resolucion;

    @ManyToOne()
    @JoinColumn(name = "id_tipoagente",foreignKey = @ForeignKey(name = "FK_INSCRRENADE_TIPOAGENTE"))
    private Tipoagente tipoagente;

    @OneToMany(mappedBy = "inscripcionrenade")
    private List<Listarelacion> listarelacion;

}
