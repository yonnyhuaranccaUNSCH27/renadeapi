package ipd.renade.renadeapi.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApoderadosDTO {
    private Integer idApoderados;

    private String ocupacion;
    private String observacion;

    private TipoapoderadoDTO tipoapoderado;

    private PersonaDTO persona;

    private GradoinstruccionDTO gradoinstruccion;

    @JsonManagedReference
    private List<ListapadresDTO> listapadres;
}
