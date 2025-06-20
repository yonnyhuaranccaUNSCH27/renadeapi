package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Diassemana;
import ipd.renade.renadeapi.repository.IDiassemanaRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IDiassemanaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiassemanaServiceImpl extends CRUDImpl<Diassemana,Integer> implements IDiassemanaService {

    private final IDiassemanaRepository diassemanaRepository;

    @Override
    protected IGenericRepo<Diassemana, Integer> getRepo() {
        return diassemanaRepository;
    }
}
