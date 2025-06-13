package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.dto.ListapartidaelectronicaReqDTO;
import ipd.renade.renadeapi.dto.ListapartidaelectronicaResDTO;
import ipd.renade.renadeapi.model.Listapartidaelectronica;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IListapartidaelectronicaRepository;
import ipd.renade.renadeapi.service.IListapartidaelectronicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListapartidaelectronicaServiceImpl extends CRUDImpl<Listapartidaelectronica,Integer> implements IListapartidaelectronicaService {

    private final IListapartidaelectronicaRepository listapartidaelectronicaRepository;

    @Override
    protected IGenericRepo<Listapartidaelectronica, Integer> getRepo() {
        return listapartidaelectronicaRepository;
    }


    @Override
    public List<ListapartidaelectronicaResDTO> findAllResumeByIDRes(Integer id) {
        return listapartidaelectronicaRepository.findByIdResolucion(id);
    }

    @Override
    public List<ListapartidaelectronicaResDTO> findAllByIdOrg(Integer id) {
        return listapartidaelectronicaRepository.findByOrganizacionId(id);
    }


}
