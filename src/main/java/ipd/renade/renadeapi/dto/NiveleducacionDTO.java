package ipd.renade.renadeapi.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NiveleducacionDTO {
    private Integer idNiveleducacion;
    
    @NotNull
    private String descripcion;
}
