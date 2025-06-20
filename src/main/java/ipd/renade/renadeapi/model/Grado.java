package ipd.renade.renadeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_grado",
        schema = "cede")
public class Grado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idGrado;

    private String descripcion;

    @ManyToOne()
    @JoinColumn(name = "id_niveleducacion", foreignKey = @ForeignKey(name = "FK_GRADO_NIVELEDUCACION"))
    private Niveleducacion niveleducacion;
}
