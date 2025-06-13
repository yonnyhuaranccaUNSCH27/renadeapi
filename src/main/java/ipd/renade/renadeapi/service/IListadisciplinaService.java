package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.model.Listadisciplina;
import java.util.List;
public interface IListadisciplinaService extends ICRUD<Listadisciplina,Integer> {
    List<Listadisciplina>findAllByIdOrg(Integer id);
}
