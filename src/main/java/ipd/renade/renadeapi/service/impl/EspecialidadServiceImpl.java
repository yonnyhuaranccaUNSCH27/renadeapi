package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Especialidad;
import ipd.renade.renadeapi.repository.IEspecialidadRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IEspecialidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EspecialidadServiceImpl extends CRUDImpl<Especialidad,Integer> implements IEspecialidadService {

    private final IEspecialidadRepository especialidadRepository;

    @Override
    protected IGenericRepo<Especialidad, Integer> getRepo() {
        return especialidadRepository;
    }
}
