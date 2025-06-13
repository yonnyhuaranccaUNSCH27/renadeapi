package ipd.renade.renadeapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectivodataDTO {
    @NotNull
    ListadirectivoDTO listadirectivo;
    @NotNull
    DirectivoDTO directivo;
    @NotNull
    PersonaDTO Persona;
}
