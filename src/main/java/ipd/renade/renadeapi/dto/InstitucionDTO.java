package ipd.renade.renadeapi.dto;

import ipd.renade.renadeapi.model.Tipoidentidad;
import ipd.renade.renadeapi.model.Tipoinscripcion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstitucionDTO {
    private Integer idInstitucion;
    private String numdocumento;
    private String codigo;
    private String descripcion;
    private String direccion;
    private String telefono;
    private String urlFilefoto;
    private String correo;
    private TipoinstitucionDTO tipoinstitucion;
    private TipogestionDTO tipogestion;
    private UbigeoDTO ubigeo;
    private TipoidentidadDTO tipoidentidad;
}
