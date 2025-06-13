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
@Table(name = "tbl_denominaciondeportivo")
public class Denominaciondeportivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDenominaciondeportivo;

    @Column(nullable = false, length = 200)
    private String codigo;

    @Column(nullable = false, length = 200)
    private String descDenominacion;

    @ManyToOne
    @JoinColumn(name = "id_tipoorganizacion",foreignKey = @ForeignKey(name = "FK_DENOM_TIPOORG"))
    private Tipoorganizacion tipoorganizacion;

    @OneToMany(mappedBy = "denominaciondeportivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asociacion> asociacion;

}
