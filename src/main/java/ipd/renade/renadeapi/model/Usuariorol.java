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
@Table(name = "tbl_usuariorol")
public class Usuariorol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idUsuariorol;

    @ManyToOne
    @JoinColumn(name = "id_rol", foreignKey = @ForeignKey(name = "FK_USUARIOROL_ROL"))
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "FK_USUARIOROL_USAURIO"))
    private Usuario usuario;
}
