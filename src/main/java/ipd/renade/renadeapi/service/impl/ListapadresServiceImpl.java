package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Listapadres;
import ipd.renade.renadeapi.repository.IListapadresRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IListapadresService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListapadresServiceImpl extends CRUDImpl<Listapadres,Integer> implements IListapadresService {

    private final IListapadresRepository listapadresRepository;

    @Override
    protected IGenericRepo<Listapadres, Integer> getRepo() {
        return listapadresRepository;
    }
}
