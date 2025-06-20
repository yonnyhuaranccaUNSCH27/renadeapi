package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Listadocente;
import ipd.renade.renadeapi.repository.IListadocenteRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IListadocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListadocenteServiceImpl extends CRUDImpl<Listadocente,Integer> implements IListadocenteService {

    private final IListadocenteRepository listadocenteRepository;

    @Override
    protected IGenericRepo<Listadocente, Integer> getRepo() {
        return listadocenteRepository;
    }
}
