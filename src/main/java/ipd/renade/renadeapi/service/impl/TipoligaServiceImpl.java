package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Tipoliga;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.ITipoligaRepository;
import ipd.renade.renadeapi.service.ITipoligaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoligaServiceImpl extends CRUDImpl<Tipoliga,Integer> implements ITipoligaService {
    private final ITipoligaRepository tipoligaRepository;

    @Override
    protected IGenericRepo<Tipoliga, Integer> getRepo() {
        return tipoligaRepository;
    }
}
