package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Mensaje;
import ipd.renade.renadeapi.repository.IMensajeRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IMensajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MensajeServiceImpl extends CRUDImpl<Mensaje,Integer> implements IMensajeService {

    private final IMensajeRepository mensajeRepository;

    @Override
    protected IGenericRepo<Mensaje, Integer> getRepo() {
        return mensajeRepository;
    }
}
