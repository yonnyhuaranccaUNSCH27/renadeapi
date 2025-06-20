package ipd.renade.renadeapi.dto;

import ipd.renade.renadeapi.model.Alumno;
import ipd.renade.renadeapi.model.Apoderados;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListapadresDTO {
    private Integer idListapadres;

    private AlumnoDTO alumnos;

    private ApoderadosDTO apoderados;

}
