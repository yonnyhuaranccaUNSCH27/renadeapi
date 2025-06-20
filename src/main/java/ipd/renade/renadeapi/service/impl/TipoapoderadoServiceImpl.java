package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Tipoapoderado;
import ipd.renade.renadeapi.repository.ITipoapoderadoRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.ITipoapoderadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoapoderadoServiceImpl extends CRUDImpl<Tipoapoderado,Integer> implements ITipoapoderadoService {

    private final ITipoapoderadoRepository tipoapoderadoRepository;

    @Override
    protected IGenericRepo<Tipoapoderado, Integer> getRepo() {
        return tipoapoderadoRepository;
    }
}
