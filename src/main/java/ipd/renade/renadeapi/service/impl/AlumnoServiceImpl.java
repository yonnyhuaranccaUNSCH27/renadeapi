package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Alumno;
import ipd.renade.renadeapi.repository.IAlumnoRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IAlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl extends CRUDImpl<Alumno,Integer> implements IAlumnoService {

    private final IAlumnoRepository alumnoRepository;

    @Override
    protected IGenericRepo<Alumno, Integer> getRepo() {
        return alumnoRepository;
    }
}
