package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Tipoinscripcion;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.ITipoinscripcionRepository;
import ipd.renade.renadeapi.service.ITipoinscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoinscripcionServiceImpl extends CRUDImpl<Tipoinscripcion,Integer> implements ITipoinscripcionService {
    private final ITipoinscripcionRepository tipoinscripcionRepository;

    @Override
    protected IGenericRepo<Tipoinscripcion, Integer> getRepo() {
        return tipoinscripcionRepository;
    }
}
