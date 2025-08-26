package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Tipomensaje;
import ipd.renade.renadeapi.repository.ITipomensajeRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.ITipomensajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipomensajeServiceImpl extends CRUDImpl<Tipomensaje,Integer> implements ITipomensajeService {

    private final ITipomensajeRepository tipomensajeRepository;

    @Override
    protected IGenericRepo<Tipomensaje, Integer> getRepo() {
        return tipomensajeRepository;
    }
}
