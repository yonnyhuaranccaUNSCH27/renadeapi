package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Menu;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IMenuRepository;
import ipd.renade.renadeapi.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends CRUDImpl<Menu,Integer> implements IMenuService {
    private final IMenuRepository menuRepository;

    @Override
    protected IGenericRepo<Menu, Integer> getRepo() {
        return menuRepository;
    }

    @Override
    public List<Menu> getMenuByUsername(String username) {

        return menuRepository.getMenuByUsername(username);
    }
}
