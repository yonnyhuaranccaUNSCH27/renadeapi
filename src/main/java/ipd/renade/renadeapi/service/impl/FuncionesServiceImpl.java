package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Funciones;
import ipd.renade.renadeapi.repository.IFuncionesRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IFuncionesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuncionesServiceImpl extends CRUDImpl<Funciones,Integer> implements IFuncionesService {
    private final IFuncionesRepository funcionesRepository;

    @Override
    protected IGenericRepo<Funciones, Integer> getRepo() {
        return funcionesRepository;
    }
}
