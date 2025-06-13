package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Oficina;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IOficinaRepository;
import ipd.renade.renadeapi.service.IOficinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OficinaServiceImpl extends CRUDImpl<Oficina,Integer> implements IOficinaService {
    private final IOficinaRepository oficinaRepository;

    @Override
    protected IGenericRepo getRepo() {
        return oficinaRepository;
    }
}
