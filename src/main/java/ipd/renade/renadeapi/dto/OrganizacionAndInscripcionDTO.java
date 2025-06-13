package ipd.renade.renadeapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizacionAndInscripcionDTO {
   private String sigla;
   private String codigo;
   private String ubidpto;
   private String ubiprovincia;
   private String ubidiscrito;
   private String denominacion;


}
