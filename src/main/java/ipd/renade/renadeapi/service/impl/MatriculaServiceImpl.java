package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Matricula;
import ipd.renade.renadeapi.repository.IMatriculaRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl extends CRUDImpl<Matricula,Integer> implements IMatriculaService {

    private final IMatriculaRepository matriculaRepository;

    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return matriculaRepository;
    }
}
