package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Listadisciplinascedeadmin;
import ipd.renade.renadeapi.repository.IListadisciplinascedeadminRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IListadisciplinascedeadminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListadisciplinascedeadminServiceImpl extends CRUDImpl<Listadisciplinascedeadmin,Integer> implements IListadisciplinascedeadminService {

    private final IListadisciplinascedeadminRepository listadisciplinascedeadminRepository;

    @Override
    protected IGenericRepo<Listadisciplinascedeadmin, Integer> getRepo() {
        return listadisciplinascedeadminRepository;
    }
}
