package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Docente;
import ipd.renade.renadeapi.repository.IDocenteRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IDocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocenteServiceImpl extends CRUDImpl<Docente,Integer> implements IDocenteService {

    private final IDocenteRepository docenteRepository;

    @Override
    protected IGenericRepo<Docente, Integer> getRepo() {
        return docenteRepository;
    }
}
