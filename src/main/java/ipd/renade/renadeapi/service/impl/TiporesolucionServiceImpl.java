package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Tiporesolucion;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.ITiporesolucionRepository;
import ipd.renade.renadeapi.service.ITiporesolucionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TiporesolucionServiceImpl extends CRUDImpl<Tiporesolucion,Integer> implements ITiporesolucionService {
    private final ITiporesolucionRepository tiporesolucionRepository;

    @Override
    protected IGenericRepo<Tiporesolucion, Integer> getRepo() {
        return tiporesolucionRepository;
    }
}
