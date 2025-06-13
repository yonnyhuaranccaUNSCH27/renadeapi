package ipd.renade.renadeapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizacionReqDTO {
    private Integer idOrganizacion;
    @NotNull
    private String descDenominacion;

    private String codigo;

    private String direccion;

    private String telefono;

    private String correo;

    @NotNull
    private Date fechaInicioactividad;
    private LocalDateTime fechaRegistro;
    private Integer estado;

    private Integer idUbigeo;
    private Integer idTipoorganizacion;
    private Integer idTipoliga;
    private Integer idDenominacion;
}
