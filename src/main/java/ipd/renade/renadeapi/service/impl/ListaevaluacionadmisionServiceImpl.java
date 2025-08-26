package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Listaevaluacionadmision;
import ipd.renade.renadeapi.repository.IListaevaluacionadmisionRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IListaevaluacionadmisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListaevaluacionadmisionServiceImpl extends CRUDImpl<Listaevaluacionadmision,Integer> implements IListaevaluacionadmisionService {

    private final IListaevaluacionadmisionRepository alumnoRepository;

    @Override
    protected IGenericRepo<Listaevaluacionadmision, Integer> getRepo() {
        return alumnoRepository;
    }
}
