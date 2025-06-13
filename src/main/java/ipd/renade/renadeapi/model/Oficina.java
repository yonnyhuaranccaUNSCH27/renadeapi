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
@Table(name = "tbl_oficina")
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idOficina;

    @Column(nullable = false, length = 120)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idTipooficina",nullable = false, foreignKey = @ForeignKey(name = "FK_OFICINA_TIPOOFICINA"))
    private Tipooficina tipooficina;

}
