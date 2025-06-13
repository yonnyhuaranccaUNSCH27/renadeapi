package ipd.renade.renadeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_trabajador")
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idTrabajador;

    private Date fechaIngreso;
    private Date fechaCese;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String motivoCese;

    @Column(nullable = false, length = 80)
    private String numContrato;
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "id_persona",foreignKey = @ForeignKey(name = "FK_TRABAJADOR_PERSONA"))
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_tipotrabajador",foreignKey = @ForeignKey(name = "FK_TRABAJADOR_TIPOTRAB"))
    private Tipotrabajador tipotrabajador;

    @ManyToOne
    @JoinColumn(name = "id_oficina",foreignKey = @ForeignKey(name = "FK_TRABAJADOR_OFICINA"))
    private Oficina oficina;

}
