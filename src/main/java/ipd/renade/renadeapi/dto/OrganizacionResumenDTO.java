package ipd.renade.renadeapi.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class OrganizacionResumenDTO {
    private Integer idOrganizacion;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String institucion;
    private String tipoliga;
    private String departamento;
    private String provincia;
    private String distrito;
    private String correo;
    private String direccion;
    private String telefono;
    private LocalDateTime fechaRegistro;
    private Date fechaInicioactividad;
    private Integer tipoorganizacion;
    //private List<Map<String, Object>> resoluciones;
    //private List<Map<String, Object>> directivos;
    //private List<Map<String, Object>> disciplinas;
    //private List<Map<String, Object>> partidasElectronicas;
    //private List<Map<String, Object>> afiliaciones;

    public OrganizacionResumenDTO(Integer idOrganizacion, String codigo, String nombre, String descripcion, String institucion, String tipoliga, String departamento, String provincia, String distrito, String correo, String direccion, String telefono, LocalDateTime fechaRegistro, Date fechaInicioactividad, Integer tipoorganizacion) {
        this.idOrganizacion = idOrganizacion;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.institucion = institucion;
        this.tipoliga = tipoliga;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
        this.fechaInicioactividad = fechaInicioactividad;
        this.tipoorganizacion = tipoorganizacion;
        //this.resoluciones = new ArrayList<Map<String, Object>>();
        //this.directivos = new ArrayList<Map<String, Object>>();
        //this.disciplinas = new ArrayList<Map<String, Object>>();
        //this.partidasElectronicas = new ArrayList<Map<String, Object>>();
        //this.afiliaciones = new ArrayList<Map<String, Object>>();
    }
}
