package ipd.renade.renadeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListapartidaelectronicaResDTO {
        private Integer idListapartidaelectronica;
        private String descripcion;
        private String numResrenade;
        private String numPartida;
        private Integer idResolucion;
        private Integer idPartidaelectronica;
        private String numInscripcion;
        private String numOrden;
        private String codUbigeo;
        private String codDisciplina;


}