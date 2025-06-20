package ipd.renade.renadeapi.dto;

import ipd.renade.renadeapi.model.*;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {
    private Integer idMatricula;

    private String nombreorganizacion;
    private LocalDateTime fcompetencia;
    private LocalDateTime fregistro;

    private AlumnoDTO alumno;

    private MeritoDTO merito;

    private CategoriaDTO categoria;

    private DisciplinaDTO disciplina;

    private AnosDTO anos;

    private ModalidadDTO modalidad;

    private GradoDTO grado;
}
