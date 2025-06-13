package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Denominacion;
import ipd.renade.renadeapi.repository.IDenominacionRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IDenominacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DenominacionServiceImpl extends CRUDImpl<Denominacion, Integer> implements IDenominacionService {
    private final IDenominacionRepository denominacionRepository;

    @Override
    protected IGenericRepo<Denominacion, Integer> getRepo() {
        return denominacionRepository;
    }
}
