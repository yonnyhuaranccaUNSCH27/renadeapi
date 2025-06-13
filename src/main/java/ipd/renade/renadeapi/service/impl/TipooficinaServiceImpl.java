package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Tipooficina;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.ITipooficinaRepository;
import ipd.renade.renadeapi.service.ITipooficinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipooficinaServiceImpl extends CRUDImpl<Tipooficina,Integer> implements ITipooficinaService {
    private final ITipooficinaRepository tipooficinaRepository;

    @Override
    protected IGenericRepo<Tipooficina, Integer> getRepo() {
        return tipooficinaRepository;
    }
}
