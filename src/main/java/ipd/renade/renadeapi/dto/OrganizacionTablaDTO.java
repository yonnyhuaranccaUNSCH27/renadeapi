package ipd.renade.renadeapi.dto;

import ipd.renade.renadeapi.model.Institucion;
import ipd.renade.renadeapi.model.Listadisciplina;
import ipd.renade.renadeapi.model.Tipoliga;
import ipd.renade.renadeapi.service.IAfiliacionService;
import ipd.renade.renadeapi.util.MapperUtil;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Data
public class OrganizacionTablaDTO {
    @Getter
    private Integer idOrganizacion;
    private String nombre;
    private String sigla;
    private String codigo;
    private String institucion;
    private String tipoliga;
    @Getter
    private List<Map<String,String>> disciplinas;
    private String departamento;
    private String provincia;
    private String distrito;
    private String direccion;
    private String telefono;

    public OrganizacionTablaDTO(
            Integer idOrganizacion,
            String nombre,
            String sigla,
            String codigo,
            String institucion,
            String tipoliga,
            //List<Listadisciplina> disciplinas,
            String departamento,
            String provincia,
            String distrito,
            String direccion,
            String telefono) {
        this.idOrganizacion = idOrganizacion;
        this.sigla = sigla;
        this.codigo = codigo;
        this.nombre = nombre;
        this.institucion = institucion;
        this.tipoliga = tipoliga;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.direccion = direccion;
        this.telefono = telefono;
        this.disciplinas = new ArrayList<Map<String,String>>();
    }
}
