package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Listagradoscedeadmin;
import ipd.renade.renadeapi.repository.IListagradoscedeadminRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IListagradoscedeadminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListagradoscedeadminServiceImpl extends CRUDImpl<Listagradoscedeadmin,Integer> implements IListagradoscedeadminService {

    private final IListagradoscedeadminRepository listagradoscedeadminRepository;

    @Override
    protected IGenericRepo<Listagradoscedeadmin, Integer> getRepo() {
        return listagradoscedeadminRepository;
    }
}
