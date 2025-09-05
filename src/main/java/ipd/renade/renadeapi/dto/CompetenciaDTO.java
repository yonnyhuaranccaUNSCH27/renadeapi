package ipd.renade.renadeapi.dto;

import ipd.renade.renadeapi.model.*;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetenciaDTO {
    private Integer idCompetencia;

    private String nombreorganizacion;
    private LocalDate fcompetencia;
    private LocalDate fcompetenciafinal;
    private LocalDateTime fregistro;
    private Integer tipologro;
    private Integer tiponacionalidad; //1:Perú 2:otro
    private String nombrepais;

    private UbigeoDTO ubigeo;

    private AlumnoDTO alumno;

    private MeritoDTO merito;

    private CategoriaDTO categoria;

    private DisciplinaDTO disciplina;

    private ModalidadDTO modalidad ;

    private GradoDTO grado;

    private SeccionDTO seccion;

    private AnosDTO anos;
}
