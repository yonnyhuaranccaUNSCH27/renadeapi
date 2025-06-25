package ipd.renade.renadeapi.dto;

import ipd.renade.renadeapi.model.Categoria;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActividadDTO {
    private Integer idActividad;
    private String titulo;
    private String subtitulo;

    @Column(nullable = false, length = 10000)  // Esto define el tamaño máximo en la base de datos
    @Size(max = 10000, message = "La descripción no puede tener más de 600 caracteres")  // Esto define la validación a nivel de aplicación
    private String descripcion;

    private LocalDateTime fpublicacion;
    private String urlimagenprincipal;
    private String urlimagen1;
    private String urlimagen2;
    private String urlimagen3;
    private String urlimagen4;
    private String urlimagen5;
    private String urlvideo;
    private String urldocumento;
    private Integer totallike;
    private Integer totaldislike;
    private Integer totalvisitas;
    private Integer totalcompartida;
    private Integer estado;
    private CategoriaDTO categoria;
}
