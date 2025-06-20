package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Curso;
import ipd.renade.renadeapi.repository.ICursoRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl extends CRUDImpl<Curso,Integer> implements ICursoService {

    private final ICursoRepository cursoRepository;

    @Override
    protected IGenericRepo<Curso, Integer> getRepo() {
        return cursoRepository;
    }
}
