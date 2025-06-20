package ipd.renade.renadeapi.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ipd.renade.renadeapi.model.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    private Integer idCurso;

    @NotNull
    private String titulo;

    private String subtitulo;

    private LocalDate fechaInicio;

    private LocalDate fechaFinal;

    private Integer duracionsemanas;

    private Integer duracionhoras;

    private Integer cupos;


    private Double costo;

    private Double costoremate;

    private Integer estado;

    @Column(nullable = false, length = 6000)  // Esto define el tamaño máximo en la base de datos
    @Size(max = 6000, message = "La descripción no puede tener más de 600 caracteres")  // Esto define la validación a nivel de aplicación
    private String descripcion;

    private String urlimagen;

    private CategoriaDTO categoria;

    private GradoDTO grado;

    private ModalidadDTO modalidad;

    @JsonManagedReference
    private List<ListadocenteDTO> listadocente;

    @JsonManagedReference
    private List<ListahorariosDTO> listahorarios;
}
