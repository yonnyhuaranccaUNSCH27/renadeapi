package ipd.renade.renadeapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InscripcionrenadeResDTO {

    private Integer idInscripcionrenade;
    @NotNull
    private String motivo;
    private String observacion;
    private String sigla;
    private String codigo;
    private boolean activo;
    @NotNull
    private TipoinscripcionDTO tipoinscripcion;
    private UbigeoDTO ubigeo;
    private ResolucionDTO resolucion;
    @NotNull
    private TipoagenteDTO tipoagente;
private List<ListarelacionResDTO> listarelacion;

}
