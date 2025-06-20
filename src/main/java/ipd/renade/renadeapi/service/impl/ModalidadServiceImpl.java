package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Modalidad;
import ipd.renade.renadeapi.repository.IModalidadRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IModalidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModalidadServiceImpl extends CRUDImpl<Modalidad,Integer> implements IModalidadService {

    private final IModalidadRepository modalidadRepository;

    @Override
    protected IGenericRepo<Modalidad, Integer> getRepo() {
        return modalidadRepository;
    }
}
