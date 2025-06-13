package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Tipoorganizacion;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.ITipoorganizacionRepository;
import ipd.renade.renadeapi.service.ITipoorganizacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoorganizacionServiceImpl extends CRUDImpl<Tipoorganizacion,Integer> implements ITipoorganizacionService {
    private final ITipoorganizacionRepository tipoorganizacionRepository;

    @Override
    protected IGenericRepo<Tipoorganizacion, Integer> getRepo() {
        return tipoorganizacionRepository;
    }
}
