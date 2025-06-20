package ipd.renade.renadeapi.dto;

import ipd.renade.renadeapi.model.Persona;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDTO {
    private Integer idAlumno;
    private String codigo;
    private String urlfoto;

    private PersonaDTO persona;
}
