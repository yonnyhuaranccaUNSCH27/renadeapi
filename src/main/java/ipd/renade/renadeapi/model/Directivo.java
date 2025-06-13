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
@Table(name = "tbl_directivo")
public class Directivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDirectivo;

    private Date fechaInicio;
    private Date fechaFinal;

    @Column(nullable = false, length = 400)
    private String observaciones;

    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "id_persona",foreignKey = @ForeignKey(name = "FK_DIRECTIVO_PERSONA"))
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_funciones",foreignKey = @ForeignKey(name = "FK_DIRECTIVO_LISTADIR"))
    private Funciones funciones;

    //@OneToMany(mappedBy = "directivo", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "directivo", cascade = CascadeType.ALL)
    private List<Listadirectivo> listadirectivo;

}
