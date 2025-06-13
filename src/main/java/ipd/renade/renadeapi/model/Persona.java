package ipd.renade.renadeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPersona;

    @Column(nullable = false, length = 20)
    private String perNumdocumento;

    @Column(nullable = false, length = 40)
    private String perNombres;

    @Column(nullable = false, length = 40)
    private String apePaterno;

    @Column(nullable = false, length = 40)
    private String apeMaterna;

    private Integer perGenero;

    //@Column(nullable = false, length = 120)
    @Column(length = 120)
    private String perDireccion;

    //@Column(nullable = false, length = 20)
    @Column(length = 20)
    private String perTelefono;

    //@Column(nullable = false, length = 120)
    @Column(length = 120)
    private String perCorreo;
    private LocalDate perFechanacimiento;

    @ManyToOne
    @JoinColumn(name = "id_ubigeo",foreignKey = @ForeignKey(name = "FK_PERSONA_UBIGEO"))
    private Ubigeo ubigeo;

    @ManyToOne
    @JoinColumn(name = "id_tipoidentidad",foreignKey = @ForeignKey(name = "FK_PERSONA_TIPOIDENTIDAD"))
    private Tipoidentidad tipoidentidad;
}
