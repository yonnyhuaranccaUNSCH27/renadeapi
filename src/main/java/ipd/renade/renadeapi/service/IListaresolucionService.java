package ipd.renade.renadeapi.service;
import ipd.renade.renadeapi.model.Listaresolucion;

import java.util.List;
import java.util.Map;

public interface IListaresolucionService extends ICRUD<Listaresolucion,Integer> {
    void deleteByIdResolucion(Integer idResolucion);

    List<Listaresolucion> findAllByIdOrg(Integer id);
    Map<Integer, Long> findCountByTipoOrg();

}
