package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Horarios;
import ipd.renade.renadeapi.repository.IHorariosRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IHorariosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HorariosServiceImpl extends CRUDImpl<Horarios,Integer> implements IHorariosService {

    private final IHorariosRepository horariosRepository;

    @Override
    protected IGenericRepo<Horarios, Integer> getRepo() {
        return horariosRepository;
    }
}
