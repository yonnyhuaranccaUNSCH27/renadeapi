package ipd.renade.renadeapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {
    private Integer idMenu;
    private String icono;
    private String nombre_menu;
    private String url_menu;
}
