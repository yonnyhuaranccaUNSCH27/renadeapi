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
@Table(name = "tbl_ubigeo")
public class Ubigeo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idUbigeo;

    @Column(nullable = false, length = 10)
    private String ubipais;

    @Column(nullable = false, length = 10)
    private String ubidpto;

    @Column(nullable = false, length = 10)
    private String ubiprovincia;

    @Column(nullable = false, length = 10)
    private String ubidiscrito;

    @Column(nullable = false, length = 200)
    private String denominacion;

    private String longitud;

    private String latitud;

    private Integer poblacion;

    private String superficie;

    private Integer ubiestado;
}
