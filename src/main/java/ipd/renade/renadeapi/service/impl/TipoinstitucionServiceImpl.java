package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Tipoinstitucion;
import ipd.renade.renadeapi.repository.ITipoinstitucionRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.ITipoinstitucionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoinstitucionServiceImpl extends CRUDImpl<Tipoinstitucion,Integer> implements ITipoinstitucionService {
    private final ITipoinstitucionRepository tipoinstitucionRepository;

    @Override
    protected IGenericRepo<Tipoinstitucion, Integer> getRepo() {
        return tipoinstitucionRepository;
    }
}
