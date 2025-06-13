package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.dto.ResolucionNumeroDTO;
import ipd.renade.renadeapi.model.Listaresolucion;
import ipd.renade.renadeapi.model.Organizacion;
import ipd.renade.renadeapi.model.Resolucion;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IListaresolucionRepository;
import ipd.renade.renadeapi.repository.IOrganizacionRepository;
import ipd.renade.renadeapi.repository.IResolucionRepository;
import ipd.renade.renadeapi.service.IListaresolucionService;
import ipd.renade.renadeapi.service.IOrganizacionService;
import ipd.renade.renadeapi.service.IResolucionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResolucionServiceImpl extends CRUDImpl<Resolucion,Integer> implements IResolucionService {
    private final IResolucionRepository resolucionRepository;
    private final IListaresolucionService listaresolucionService;
    private final IOrganizacionService organizacionService;

    @Override
    protected IGenericRepo<Resolucion, Integer> getRepo() {
        return resolucionRepository;
    }

    @Override
    public List<Resolucion> findResolucionByOrganizacion(Integer idOrganizacion) {
        return resolucionRepository.findResolucionByOrganizacion(idOrganizacion);
    }

    @Override
    public List<ResolucionNumeroDTO> findResolucionNroByOrganizacion(Integer idOrganizacion) {
        return resolucionRepository.findResolucionNroByOrganizacion(idOrganizacion);
    }

    @Transactional
    public Resolucion saveResolucionOrganizacion(Integer idOrganizacion, Resolucion resolucion){
        Resolucion res = resolucionRepository.save(resolucion);
        Organizacion org = organizacionService.findById(idOrganizacion);
        Listaresolucion obj = new Listaresolucion();
        obj.setOrganizacion(org);
        obj.setResolucion(res);
        listaresolucionService.save(obj);
        return res;
    }

    @Transactional
    public void deleteResolucion(Integer idResolucion){
        listaresolucionService.deleteByIdResolucion(idResolucion);
        resolucionRepository.deleteById(idResolucion);
    }
}
