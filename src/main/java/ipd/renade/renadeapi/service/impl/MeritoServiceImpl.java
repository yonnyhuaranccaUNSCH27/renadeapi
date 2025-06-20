package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Merito;
import ipd.renade.renadeapi.repository.IMeritoRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IMeritoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeritoServiceImpl extends CRUDImpl<Merito,Integer> implements IMeritoService {

    private final IMeritoRepository meritoRepository;

    @Override
    protected IGenericRepo<Merito, Integer> getRepo() {
        return meritoRepository;
    }
}
