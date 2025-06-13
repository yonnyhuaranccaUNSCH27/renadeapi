package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Asociacion;
import ipd.renade.renadeapi.repository.IAsociacionRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IAsociacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsociacionServiceImpl extends CRUDImpl<Asociacion,Integer> implements IAsociacionService {

    private final IAsociacionRepository asociacionRepository;

    @Override
    protected IGenericRepo<Asociacion, Integer> getRepo() {
        return asociacionRepository;
    }
}
