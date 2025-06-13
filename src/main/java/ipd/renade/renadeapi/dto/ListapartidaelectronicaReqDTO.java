package ipd.renade.renadeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListapartidaelectronicaReqDTO {
        private Integer idListapartidaelectronica;
        private String descripcion;
        private Integer idResolucion;
        private Integer idPartidaelectronica;

}