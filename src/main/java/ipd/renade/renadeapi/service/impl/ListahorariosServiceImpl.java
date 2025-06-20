package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Listahorarios;
import ipd.renade.renadeapi.repository.IListahorariosRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IListahorariosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListahorariosServiceImpl extends CRUDImpl<Listahorarios,Integer> implements IListahorariosService {

    private final IListahorariosRepository listahorariosRepository;

    @Override
    protected IGenericRepo<Listahorarios, Integer> getRepo() {
        return listahorariosRepository;
    }
}
