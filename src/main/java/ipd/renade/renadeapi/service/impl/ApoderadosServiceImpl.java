package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Apoderados;
import ipd.renade.renadeapi.repository.IApoderadosRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IApoderadosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApoderadosServiceImpl extends CRUDImpl<Apoderados,Integer> implements IApoderadosService {

    private final IApoderadosRepository apoderadosRepository;

    @Override
    protected IGenericRepo<Apoderados, Integer> getRepo() {
        return apoderadosRepository;
    }
}
