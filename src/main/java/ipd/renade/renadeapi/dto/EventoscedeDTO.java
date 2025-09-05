package ipd.renade.renadeapi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoscedeDTO {
    private Integer idEventoscede;
    private LocalDateTime fechainicio;
    private LocalDateTime fechafinal;
    private String titulo;
    private CategoriaDTO categoria;
    private String localidad;
    private String organizador;
    private String duracion;
    private String observacion;
    private DisciplinaDTO disciplina;
    private Integer estado;
}
