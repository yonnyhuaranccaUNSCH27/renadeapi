package ipd.renade.renadeapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajeDTO {
    private Integer idMensaje;

    @NotNull
    private String asunto;

    @NotNull
    private String mensaje;

    private LocalDateTime fenvio;
    private Integer estado;

    private TipomensajeDTO tipomensaje;
    private PersonaDTO persona;
}
