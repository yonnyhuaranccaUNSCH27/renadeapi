package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Admision;
import ipd.renade.renadeapi.repository.IAdmisionRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IAdmisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdmisionServiceImpl extends CRUDImpl<Admision,Integer> implements IAdmisionService {

    private final IAdmisionRepository admisionRepository;

    @Override
    protected IGenericRepo<Admision, Integer> getRepo() {
        return admisionRepository;
    }
}
