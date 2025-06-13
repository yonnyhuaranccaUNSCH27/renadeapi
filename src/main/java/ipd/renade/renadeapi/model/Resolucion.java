package ipd.renade.renadeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_resolucion")
public class Resolucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idResolucion;

    @Column(nullable = false, length = 300)
    private String denominacion;

    @Column(nullable = false, length = 80)
    private String numExpediente;

    private Date fechaExpediente;

    @Column(nullable = false, length = 80)
    private String numResrenade;

    private Date fechaResrenade;

    //@Column(nullable = false, length = 80)
    @Column(length = 80)
    private String numPartElectEstatuto;

    //@Column(nullable = false, length = 80)
    @Column(length = 80)
    private String numPartElectSunarp;

    private Date fechaPartElectSunarp;

    //@Column(nullable = false, length = 80)
    @Column(length = 80)
    private String numZonaRegistral;

    //@Column(nullable = false, length = 200)
    @Column(length = 200)
    private String oficinaRegistral;

    //@Column(nullable = false, length = 80)
    @Column(length = 80)
    private String numAsientoRegistral;

    //@Column(nullable = false, length = 80)
    @Column(length = 80)
    private String numConstAf;

    private Date fechaConstAf;

    //@Column(nullable = false, length = 80)
    @Column(length = 80)
    private String numResConsejoDir;

    private Date fechaResConsejoDir;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer periodo;

    //@Column(nullable = false, length = 500)
    @Column(length = 500)
    private String descripcion;

    //@Column(nullable = false, length = 500)
    @Column(length = 500)
    private String observacion;
    private LocalDateTime fechaRegistro;

    //@Column(nullable = false, columnDefinition = "TEXT")
    @Column(columnDefinition = "TEXT")
    private String urlResRenade;

    //@Column(nullable = false, columnDefinition = "TEXT")
    @Column(columnDefinition = "TEXT")
    private String urlFileresenade;

    @ManyToOne
    @JoinColumn(name = "id_tiporesolucion",foreignKey = @ForeignKey(name = "FK_RESOLUCION_TIPORES"))
    private Tiporesolucion tiporesolucion;

    @OneToMany(mappedBy = "resolucion")
    private List<Listaresolucion> listaresoluciones;

}
