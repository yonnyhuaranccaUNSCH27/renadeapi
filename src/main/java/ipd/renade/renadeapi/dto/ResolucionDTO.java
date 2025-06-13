package ipd.renade.renadeapi.dto;

import ipd.renade.renadeapi.model.Tiporesolucion;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResolucionDTO {

    private Integer idResolucion;

    @NotNull
    private String denominacion;

    @NotNull
    private String numExpediente;

    private Date fechaExpediente;

    @NotNull
    private String numResrenade;

    private Date fechaResrenade;

    //@NotNull
    private String numPartElectEstatuto;


    private String numPartElectSunarp;

    private Date fechaPartElectSunarp;


    private String numZonaRegistral;


    private String oficinaRegistral;


    private String numAsientoRegistral;


    private String numConstAf;

    private Date fechaConstAf;


    private String numResConsejoDir;

    private Date fechaResConsejoDir;
    private Date fechaInicio;
    private Date fechaFin;


    private String descripcion;


    private String observacion;
    private LocalDateTime fechaRegistro;


    private String urlResRenade;


    private String urlFileresenade;

    private Integer idTiporesolucion;
    private Integer periodo;

}
