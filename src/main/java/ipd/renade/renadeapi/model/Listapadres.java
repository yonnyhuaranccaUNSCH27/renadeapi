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
@Table(name = "tbl_listapadres",
        schema = "cede")
public class Listapadres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idListapadres;

    @ManyToOne()
    @JoinColumn(name = "id_alumnos", foreignKey = @ForeignKey(name = "FK_LISTAPADRES_ALUMNO"))
    private Alumno alumnos;

    @ManyToOne()
    @JoinColumn(name = "id_apoderados", foreignKey = @ForeignKey(name = "FK_LISTAPADRES_APODERADO"))
    private Apoderados apoderados;

}
