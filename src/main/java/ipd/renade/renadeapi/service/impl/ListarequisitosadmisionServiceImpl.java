package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Listarequisitosadmision;
import ipd.renade.renadeapi.repository.IListarequisitosadmisionRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IListarequisitosadmisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListarequisitosadmisionServiceImpl extends CRUDImpl<Listarequisitosadmision,Integer> implements IListarequisitosadmisionService {

    private final IListarequisitosadmisionRepository alumnoRepository;

    @Override
    protected IGenericRepo<Listarequisitosadmision, Integer> getRepo() {
        return alumnoRepository;
    }
}
