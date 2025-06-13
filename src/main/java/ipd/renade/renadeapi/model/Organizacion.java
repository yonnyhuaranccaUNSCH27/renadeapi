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
@Table(name = "tbl_organizacion")
public class Organizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idOrganizacion;

    @Column(nullable =false, length = 200)
    private String descDenominacion;

    @Column(nullable = true, length = 20)
    private String sigla;

    @Column(nullable = false, length = 20)
    private String codigo;

    @Column(nullable = false, length = 120)
    private String direccion;

    @Column(nullable = false, length = 30)
    private String telefono;

    @Column(nullable = false, length = 120)
    private String correo;

    private String descripcion;

    private Date fechaInicioactividad;
    private LocalDateTime fechaRegistro;
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "id_ubigeo",foreignKey = @ForeignKey(name = "FK_ORG_UBIGEO"))
    private Ubigeo ubigeo;

    @ManyToOne
    @JoinColumn(name = "id_tipoorganizacion",foreignKey = @ForeignKey(name = "FK_ORG_TIPOORG"))
    private Tipoorganizacion tipoorganizacion;

    @ManyToOne
    @JoinColumn(name = "id_tipoliga",foreignKey = @ForeignKey(name = "FK_ORG_TIPOLIGA"))
    private Tipoliga tipoliga;

    @ManyToOne
    @JoinColumn(name = "id_denominacion",foreignKey = @ForeignKey(name = "FK_ORG_DENOMINACION"))
    private Denominacion denominacion;

    @ManyToOne
    @JoinColumn(name = "id_institucion",foreignKey = @ForeignKey(name = "FK_ORG_INSTITUCION"))
    private Institucion institucion;

    //@OneToMany(mappedBy = "organizacion")
    //private List<Asociacion> asociacion;

    @OneToMany(mappedBy = "organizacion")
    private List<Listadisciplina> listadisciplina;

    @OneToMany(mappedBy = "organizacion")
    private List<Listadirectivo> listadirectivo;

    @OneToMany(mappedBy = "organizacion")
    private List<Listaresolucion> listaresolucion;

    @OneToMany(mappedBy = "organizacion")
    private List<Asociacion> afiliacion;
}