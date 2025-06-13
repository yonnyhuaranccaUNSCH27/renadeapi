package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Afiliacion;
import ipd.renade.renadeapi.repository.IAfiliacionRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IAfiliacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AfiliacionServiceImpl extends CRUDImpl<Afiliacion,Integer> implements IAfiliacionService {

    private final IAfiliacionRepository afiliacionRepository;

    @Override
    protected IGenericRepo<Afiliacion, Integer> getRepo() {
        return afiliacionRepository;
    }

    @Override
    public List<Afiliacion> findByOrgAfiliada(Integer idOrganizacion) {
        return afiliacionRepository.findByIdOrganizacionAfiliada(idOrganizacion);
    }
}
