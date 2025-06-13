package ipd.renade.renadeapi.service.impl;


import ipd.renade.renadeapi.model.Menurol;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IMenurolRepository;
import ipd.renade.renadeapi.service.IMenuRolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuRolServiceImpl extends CRUDImpl<Menurol,Integer> implements IMenuRolService {
    private final IMenurolRepository menuRolRepository;

    @Override
    protected IGenericRepo<Menurol, Integer> getRepo() {
        return menuRolRepository;
    }
}
