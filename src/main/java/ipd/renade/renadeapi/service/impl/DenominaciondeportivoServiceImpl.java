package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Denominaciondeportivo;
import ipd.renade.renadeapi.repository.IDenominaciondeportivoRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;

import ipd.renade.renadeapi.service.IDenominaciondeportivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DenominaciondeportivoServiceImpl extends CRUDImpl<Denominaciondeportivo,Integer> implements IDenominaciondeportivoService {

    private final IDenominaciondeportivoRepository denominaciondeportivoRepository;


    @Override
    protected IGenericRepo<Denominaciondeportivo, Integer> getRepo() {
        return denominaciondeportivoRepository;
    }
}
