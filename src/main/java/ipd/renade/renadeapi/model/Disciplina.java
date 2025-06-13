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
@Table(name = "tbl_disciplina")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDisciplina;

    private String codigo;

    @Column(nullable = false, length = 200)
    private String descripcion;

    @OneToMany(mappedBy = "disciplina")
    private List<Listadisciplina> listadisciplina;

    @OneToMany(mappedBy = "disciplina")
    private List<Listarelacion> listarelacion;
}
