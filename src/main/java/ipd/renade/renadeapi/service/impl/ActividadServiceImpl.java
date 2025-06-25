package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Actividad;
import ipd.renade.renadeapi.repository.IActividadRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IActividadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActividadServiceImpl extends CRUDImpl<Actividad,Integer> implements IActividadService {

    private final IActividadRepository actividadRepository;

    @Override
    protected IGenericRepo<Actividad, Integer> getRepo() {
        return actividadRepository;
    }

    @Override
    public List<Actividad> findByTitulo(String titulo){
        return actividadRepository.findByTitulo(titulo);
    }

}
