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
@Table(name = "tbl_afiliacion")
public class Afiliacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idAfiliacion;

    @ManyToOne
    @JoinColumn(name = "id_organizacion_afiliadora",foreignKey = @ForeignKey(name = "FK_ASOC_ORG_AFILIADORA"))
    private Organizacion organizacionAfiliadora;

    @ManyToOne
    @JoinColumn(name = "id_organizacion_afiliada",foreignKey = @ForeignKey(name = "FK_ASOC_ORG_AFILIADA"))
    private Organizacion organizacionAfiliada;

    @Column(length = 255)
    private String observacion;

    @Column(nullable = false)
    private Integer estado;

    public Integer getIdAfiliacion() {
        return this.idAfiliacion;
    }
}