package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Tipoagente;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.ITipoagenteRepository;
import ipd.renade.renadeapi.service.ITipoagenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoagenteServiceImpl extends CRUDImpl<Tipoagente,Integer> implements ITipoagenteService {
    private final ITipoagenteRepository tipoagenteRepository;

    @Override
    protected IGenericRepo<Tipoagente, Integer> getRepo() {
        return tipoagenteRepository;
    }
}
