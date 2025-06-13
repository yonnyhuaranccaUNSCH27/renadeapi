package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Listaresolucion;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IListaresolucionRepository;
import ipd.renade.renadeapi.service.IListaresolucionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ListaresolucionServiceImpl extends CRUDImpl<Listaresolucion,Integer> implements IListaresolucionService {
    private final IListaresolucionRepository listaresolucionRepository;

    @Override
    protected IGenericRepo getRepo() {
        return listaresolucionRepository;
    }

    @Override
    public void deleteByIdResolucion(Integer idResolucion) {
        listaresolucionRepository.deleteByIdResolucion(idResolucion);
    }

    @Override
    public List<Listaresolucion> findAllByIdOrg(Integer id) {
        return listaresolucionRepository.findAllByOrganizacion_IdOrganizacion(id);
    }

    @Override
    public Map<Integer, Long> findCountByTipoOrg() {
        List<Object[]> resultados = listaresolucionRepository.findCountAllByIdTipoorganizacion();
        return getCountMap(resultados);
    }
    private Map<Integer, Long> getCountMap(List<Object[]> resultados) {
        Map<Integer, Long> conteos = new HashMap<>();

        for (Object[] resultado : resultados) {
            Integer id = (Integer) resultado[0];
            Long cantidad = (Long) resultado[1];
            conteos.put(id, cantidad);
        }
        return conteos;
    }
}