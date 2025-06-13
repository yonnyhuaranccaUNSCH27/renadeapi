package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Rol;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IRolRepository;
import ipd.renade.renadeapi.service.IRolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolServiceImpl extends CRUDImpl<Rol,Integer> implements IRolService {
    private final IRolRepository rolRepository;

    @Override
    protected IGenericRepo<Rol, Integer> getRepo() {
        return rolRepository;
    }
}
