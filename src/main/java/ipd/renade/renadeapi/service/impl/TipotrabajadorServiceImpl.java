package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Tipotrabajador;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.ITipotrabajadorRepository;
import ipd.renade.renadeapi.service.ITipotrabajadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipotrabajadorServiceImpl extends CRUDImpl<Tipotrabajador,Integer> implements ITipotrabajadorService {
    private final ITipotrabajadorRepository tipotrabajadorRepository;

    @Override
    protected IGenericRepo<Tipotrabajador, Integer> getRepo() {
        return tipotrabajadorRepository;
    }
}
