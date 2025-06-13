package ipd.renade.renadeapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ipd.renade.renadeapi.model.Listarelacion;
import ipd.renade.renadeapi.model.Resolucion;
import ipd.renade.renadeapi.model.Tipoagente;
import ipd.renade.renadeapi.model.Tipoinscripcion;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InscripcionrenadeDTO {

    private Integer idInscripcionrenade;

    @NotNull
    private String motivo;
    private String sigla;
    private String codigo;

    private String observacion;
    private boolean activo;
    @NotNull
    private Integer idTipoinscripcion;

    @JsonBackReference
    private ResolucionDTO resolucion;


    private Integer idTipoagente;
    private Integer idUbigeo;


}
