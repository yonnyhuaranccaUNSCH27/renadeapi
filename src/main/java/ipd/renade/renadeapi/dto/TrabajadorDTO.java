package ipd.renade.renadeapi.dto;

import ipd.renade.renadeapi.model.Oficina;
import ipd.renade.renadeapi.model.Persona;
import ipd.renade.renadeapi.model.Tipotrabajador;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrabajadorDTO {
    private Integer idTrabajador;

    private Date fechaIngreso;
    private Date fechaCese;

    private String motivoCese;

    private String numContrato;
    private Integer estado;

    @NotNull
    private PersonaDTO persona;

    @NotNull
    private TipotrabajadorDTO tipotrabajador;

    //@NotNull
    private OficinaDTO oficina;
}
