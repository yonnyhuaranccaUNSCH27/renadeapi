package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.dto.OrganizacionAfiliadoraDTO;
import ipd.renade.renadeapi.dto.OrganizacionResumenDTO;
import ipd.renade.renadeapi.dto.OrganizacionTablaDTO;
import ipd.renade.renadeapi.model.Organizacion;
import ipd.renade.renadeapi.model.Resolucion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.Map;

public interface IOrganizacionService extends ICRUD<Organizacion,Integer> {

    public Organizacion saveTransaction(Organizacion organizacion, List<Resolucion> resolucciones);

    public List<Organizacion> findByIdTipoOrganizacion(Integer idTipoOrganizacion);

    public Map<Integer, Long> findCountByTipoOrg() ;

    public Map<Integer, Long> findCountByTipoLiga() ;

    public List<OrganizacionAfiliadoraDTO> findAllOrgAfiliadora(Integer idOrganizacion);

    public List<OrganizacionTablaDTO> getInfoOrgForTable(Integer idTipoOrganizacion);

    public Organizacion saveOrganizacion(Organizacion organizacion);

    public Organizacion updateOrganizacion(Organizacion organizacion);

    public OrganizacionResumenDTO findResumenOrgById(Integer idOrganizacion);

    public Page<OrganizacionTablaDTO> findOrgByTipoForTable(Integer idTipoOrganizacion, Pageable pageable);

    public void deshabilitarOrganizacion(Integer idOrganizacion);

    public Map<String, String> generarCodigo(String sigla);
}