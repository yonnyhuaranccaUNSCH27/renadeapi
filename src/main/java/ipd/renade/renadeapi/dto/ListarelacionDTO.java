package ipd.renade.renadeapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListarelacionDTO {
    private Integer idListarelacion;

    @NotNull
    private String descripcion;
    private Integer estado;

    @NotNull
    private PersonaReqDTO persona;

    @NotNull
    private Integer idDisciplina;

    @NotNull
    private Integer idInscripcionrenade;
}
