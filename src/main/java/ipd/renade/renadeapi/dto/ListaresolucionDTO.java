package ipd.renade.renadeapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaresolucionDTO {
    private Integer idListaresolucion;

    @NotNull
    private ResolucionDTO resolucion;

    //@NotNull
    @JsonBackReference
    private OrganizacionDTO organizacion;

}
