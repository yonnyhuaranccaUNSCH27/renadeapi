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
@Table(name = "tbl_menurol")
public class Menurol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMenurol;

    @ManyToOne
    @JoinColumn (name = "id_menu",foreignKey = @ForeignKey(name = "FK_MENUROL_MENU"))
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "id_rol", foreignKey = @ForeignKey(name = "FK_MENUROL_ROL"))
    private Rol rol;
}

