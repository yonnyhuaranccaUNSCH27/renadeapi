package ipd.renade.renadeapi.dto;

import ipd.renade.renadeapi.model.Funciones;
import ipd.renade.renadeapi.model.Listadirectivo;
import ipd.renade.renadeapi.model.Persona;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectivoDTO {
    private Integer idDirectivo;

    @NotNull
    private Date fechaInicio;
    private Date fechaFinal;

    private String observaciones;

    private Integer estado;

    @NotNull
    private Integer idPersona;

    @NotNull
    private Integer idFunciones;

    private PersonaDTO persona;

    private FuncionesDTO funciones;
}
