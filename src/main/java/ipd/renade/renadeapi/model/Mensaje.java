package ipd.renade.renadeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_mensaje")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMensaje;

    @Column(nullable = false)
    private String asunto;

    @Column(nullable = false)
    private String mensaje;

    private LocalDateTime fenvio;
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "id_tipomensaje", foreignKey = @ForeignKey(name = "FK_MENSAJE_TIPOMENSAJE"))
    private Tipomensaje tipomensaje;

    @ManyToOne
    @JoinColumn(name = "id_persona", foreignKey = @ForeignKey(name = "FK_MENSAJE_PERSONA"))
    private Persona persona;
}
