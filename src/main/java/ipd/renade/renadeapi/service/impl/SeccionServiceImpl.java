package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Seccion;
import ipd.renade.renadeapi.repository.ISeccionRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.ISeccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeccionServiceImpl extends CRUDImpl<Seccion,Integer> implements ISeccionService {

    private final ISeccionRepository seccionRepository;

    @Override
    protected IGenericRepo<Seccion, Integer> getRepo() {
        return seccionRepository;
    }
}
