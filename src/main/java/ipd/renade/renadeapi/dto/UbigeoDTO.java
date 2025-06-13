package ipd.renade.renadeapi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UbigeoDTO {
    private Integer idUbigeo;

    @NotNull
    private String ubipais;

    @NotNull
    private String ubidpto;

    @NotNull
    private String ubiprovincia;

    @NotNull
    private String ubidiscrito;

    @NotNull
    private String denominacion;

    private String longitud;

    private String latitud;

    private Integer poblacion;

    private String superficie;

    private Integer ubiestado;
}
