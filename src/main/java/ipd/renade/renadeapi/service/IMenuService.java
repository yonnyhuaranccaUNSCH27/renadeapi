package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.model.Menu;

import java.util.List;

public interface IMenuService extends ICRUD<Menu,Integer> {
    List<Menu> getMenuByUsername(String username);
}
