package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Tipogestion;
import ipd.renade.renadeapi.repository.ITipogestionRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.ITipogestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipogestionServiceImpl extends CRUDImpl<Tipogestion,Integer> implements ITipogestionService {
    private final ITipogestionRepository tipogestionRepository;

    @Override
    protected IGenericRepo<Tipogestion, Integer> getRepo() {
        return tipogestionRepository;
    }
}
