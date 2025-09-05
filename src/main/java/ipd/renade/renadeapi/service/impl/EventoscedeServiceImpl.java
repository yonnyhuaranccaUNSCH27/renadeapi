package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Eventoscede;
import ipd.renade.renadeapi.repository.IEventoscedeRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IEventoscedeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventoscedeServiceImpl extends CRUDImpl<Eventoscede,Integer> implements IEventoscedeService {

    private final IEventoscedeRepository eventoscedeRepository;

    @Override
    protected IGenericRepo<Eventoscede, Integer> getRepo() {
        return eventoscedeRepository;
    }
    

}
