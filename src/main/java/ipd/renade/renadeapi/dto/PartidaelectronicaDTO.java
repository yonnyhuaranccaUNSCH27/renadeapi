package ipd.renade.renadeapi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidaelectronicaDTO {
    private Integer idPartidaelectronica;

    @NotNull
    private String numPartida;

    @NotNull
    private String numInscripcion;

    @NotNull
    private String numOrden;

    @NotNull
    private String codUbigeo;

    @NotNull
    private String codDisciplina;
}
