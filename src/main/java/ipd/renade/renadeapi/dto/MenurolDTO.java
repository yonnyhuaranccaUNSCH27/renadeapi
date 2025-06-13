package ipd.renade.renadeapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenurolDTO {
    private Integer idMenurol;

    @NotNull
    private Integer idRol;

    @NotNull
    private Integer idMenu;
}
