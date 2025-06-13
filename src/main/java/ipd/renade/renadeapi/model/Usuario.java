package ipd.renade.renadeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tbl_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idUsuario;

    @Column(nullable = false,length = 120)
    private String usernombres;

    @Column(nullable = false,length = 300)
    private String username;

    @Column(nullable = false)
    private String password;

    private Integer isActive;

    @Column(nullable = false,length = 120)
    private String email;

    private String urlFilefoto;


    private Integer termino1;
    private Integer termino2;
    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_trabajador",foreignKey = @ForeignKey(name = "FK_USUARIO_TRABAJADOR"))
    private Trabajador trabajador;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_usuariorol",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol")
    )

    private List<Rol> roles;

//    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
//    private List<Usuariorol> usuarioRoles;

}
