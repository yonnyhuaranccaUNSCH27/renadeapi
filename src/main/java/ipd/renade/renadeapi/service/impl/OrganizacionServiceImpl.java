package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.dto.OrganizacionAfiliadoraDTO;
import ipd.renade.renadeapi.dto.OrganizacionResumenDTO;
import ipd.renade.renadeapi.dto.OrganizacionTablaDTO;
import ipd.renade.renadeapi.exception.CodigoExistException;
import ipd.renade.renadeapi.model.Listadisciplina;
import ipd.renade.renadeapi.model.Organizacion;
import ipd.renade.renadeapi.model.Resolucion;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IListadisciplinaRepository;
import ipd.renade.renadeapi.repository.IOrganizacionListResRepository;
import ipd.renade.renadeapi.repository.IOrganizacionRepository;
import ipd.renade.renadeapi.service.IOrganizacionService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Length;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrganizacionServiceImpl extends CRUDImpl<Organizacion,Integer> implements IOrganizacionService {
    private final IOrganizacionRepository organizacionRepository;
    private final IOrganizacionListResRepository crRepo;
    private final IListadisciplinaRepository listadisciplinaRepository;

    @Override
    protected IGenericRepo<Organizacion, Integer> getRepo() {
        return organizacionRepository;
    }

    @Transactional
    @Override
    public Organizacion saveTransaction(Organizacion organizacion, List<Resolucion> resolucciones) {
        organizacionRepository.save(organizacion);//se guarda maestro
        resolucciones.forEach(ex->crRepo.saveResolucion(ex.getIdResolucion(),organizacion.getIdOrganizacion()));
        return organizacion;
    }

    @Override
    public List<Organizacion> findByIdTipoOrganizacion(Integer idTipoOrganizacion) {
        return organizacionRepository.findByIdTipoorganizacion(idTipoOrganizacion);
    }

    @Override
    public Map<Integer, Long> findCountByTipoOrg() {
        List<Object[]> resultados = organizacionRepository.findCountByTypeOrganizacion();
        return getCountMap(resultados);
    }

    @Override
    public Map<Integer, Long> findCountByTipoLiga() {
        List<Object[]> resultados = organizacionRepository.findCountByTypeLiga();
        return getCountMap(resultados);
    }

    @Override
    public List<OrganizacionAfiliadoraDTO> findAllOrgAfiliadora(Integer idOrganizacion) {
        return organizacionRepository.findAllOrgAfiliadora(idOrganizacion);
    }

    @Transactional
    @Override
    public List<OrganizacionTablaDTO> getInfoOrgForTable(Integer idTipoOrganizacion) {
        List<OrganizacionTablaDTO> dtoList = organizacionRepository.getInfoOrgForTable(idTipoOrganizacion);
        for(OrganizacionTablaDTO dto: dtoList){
            List<Listadisciplina> ldList = listadisciplinaRepository.findAllByOrganizacion_IdOrganizacionDesc(dto.getIdOrganizacion());
            for(Listadisciplina ld: ldList){
                Map<String,String> map = new HashMap<String,String>();
                map.put("disciplina",ld.getDisciplina().getDescripcion());
                dto.getDisciplinas().add(map);
            }
        }
        return dtoList;
    }

    @Transactional
    @Override
    public Organizacion saveOrganizacion(Organizacion organizacion) {
        Organizacion org = organizacionRepository.findBySiglaAndCodigo(organizacion.getSigla(),organizacion.getCodigo());
        System.out.println(org);
        if(org==null){
            return organizacionRepository.save(organizacion);
        }else{
            throw new CodigoExistException("Ya existe una organización registrada con el código: " + org.getSigla() + org.getCodigo());
        }
    }

    @Transactional
    @Override
    public Organizacion updateOrganizacion(Organizacion organizacion) {
        Organizacion org = organizacionRepository.findBySiglaAndCodigo(organizacion.getSigla(),organizacion.getCodigo());
        System.out.println(org);
        if(org==null){
            return organizacionRepository.save(organizacion);
        }else if(organizacion.getIdOrganizacion() == org.getIdOrganizacion()){
            return organizacionRepository.save(organizacion);
        }else{
            throw new CodigoExistException("Ya existe una organización registrada con el código: " + org.getSigla() + org.getCodigo());
        }
    }

    @Override
    public OrganizacionResumenDTO findResumenOrgById(Integer idOrganizacion) {
        return organizacionRepository.findResumenOrgById(idOrganizacion);
    }

    @Override
    public Page<OrganizacionTablaDTO> findOrgByTipoForTable(Integer idTipoOrganizacion, Pageable pageable) {
        Page<OrganizacionTablaDTO> organizaciones = organizacionRepository.findOrgByTipoForTable(idTipoOrganizacion, pageable);
        organizaciones.getContent().forEach(organizacion->{
            listadisciplinaRepository.findAllByOrganizacion_IdOrganizacionDesc(organizacion.getIdOrganizacion()).forEach(ld->{
                Map<String,String> map = new HashMap<String,String>();
                map.put("disciplina",ld.getDisciplina().getDescripcion());
                organizacion.getDisciplinas().add(map);
            });
        });
        return organizaciones;
    }

    @Transactional
    @Override
    public void deshabilitarOrganizacion(Integer idOrganizacion) {
        this.organizacionRepository.deshabilitarOrganizacion(idOrganizacion);
    }

    @Override
    public Map<String, String> generarCodigo(String sigla) {
        Integer codigoEntero = organizacionRepository.generarCodigoEntero(sigla);
        String codigo = (codigoEntero != null)
                ? String.format("%06d",codigoEntero)
                : "000001";
        Map<String, String> map = new HashMap<>();
        map.put("codigo",codigo);

        return map;
    }

    private Map<Integer, Long> getCountMap(List<Object[]> resultados) {
        Map<Integer, Long> conteos = new HashMap<>();

        for (Object[] resultado : resultados) {
            Integer id = (Integer) resultado[0];
            Long cantidad = (Long) resultado[1];
            conteos.put(id, cantidad);
        }
        return conteos;
    }

    /*
    @Override
    public Organizacion save(Organizacion organizacion) {
        return super.save(organizacion);
    }
     */
}