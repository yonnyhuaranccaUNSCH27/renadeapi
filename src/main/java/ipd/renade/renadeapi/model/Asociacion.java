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
@Table(name = "tbl_asociacion")
public class Asociacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idAsociacion;

    @ManyToOne
    @JoinColumn(name = "id_organizacion",foreignKey = @ForeignKey(name = "FK_ASOC_ORG"))
    private Organizacion organizacion;

    @ManyToOne
    @JoinColumn(name = "id_denominaciondeportivo",foreignKey = @ForeignKey(name = "FK_ASOC_DENOM"))
    private Denominaciondeportivo denominaciondeportivo;
}