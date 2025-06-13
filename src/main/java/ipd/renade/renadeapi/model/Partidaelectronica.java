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
@Table(name = "tbl_partidaelectronica")
public class Partidaelectronica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPartidaelectronica;

    @Column(nullable = false, length = 20)
    private String numPartida;

    @Column(nullable = false, length = 20)
    private String numInscripcion;

    @Column(nullable = false, length = 20)
    private String numOrden;

    @Column(nullable = false, length = 20)
    private String codUbigeo;

    @Column(nullable = false, length = 20)
    private String codDisciplina;

}
