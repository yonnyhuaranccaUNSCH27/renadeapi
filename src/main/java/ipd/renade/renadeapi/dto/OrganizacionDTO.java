package ipd.renade.renadeapi.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ipd.renade.renadeapi.model.Asociacion;
import ipd.renade.renadeapi.model.Listadirectivo;
import ipd.renade.renadeapi.model.Listadisciplina;
import jakarta.persistence.Column;
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
public class OrganizacionDTO {
    private Integer idOrganizacion;
    @NotNull
    private String descDenominacion;

    private String sigla;

    private String codigo;

    private String direccion;

    private String telefono;

    private String correo;

    private String descripcion;

    @NotNull
    private Date fechaInicioactividad;
    private LocalDateTime fechaRegistro;
    private Integer estado;

    private Integer idUbigeo;

    private Integer idTipoorganizacion;
    private Integer Organizacion;

    private Integer idTipoliga;

    private Integer idDenominacion;

    private InstitucionDTO institucion;

//    @NotNull
//    @JsonManagedReference
//    private List<AsociacionDTO> asociacion;
//
//    @NotNull
//    @JsonManagedReference
//    private List<ListadisciplinaDTO> Listadisciplina;

//    @NotNull
//    @JsonManagedReference
//    private List<ListadirectivoDTO> Listadirectivo;
//
//    @NotNull
//    @JsonManagedReference
//    private List<ListaresolucionDTO> listaresolucion;
}