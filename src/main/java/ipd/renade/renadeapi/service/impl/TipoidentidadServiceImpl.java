package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Tipoidentidad;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.ITipoidentidadRepository;
import ipd.renade.renadeapi.service.ITipoidentidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoidentidadServiceImpl extends CRUDImpl<Tipoidentidad, Integer> implements ITipoidentidadService{

    private final ITipoidentidadRepository tipoidentidadRepository;

    @Override
    protected IGenericRepo<Tipoidentidad, Integer> getRepo() {
        return tipoidentidadRepository;
    }


}
