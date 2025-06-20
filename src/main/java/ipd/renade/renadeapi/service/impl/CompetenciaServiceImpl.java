package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Competencia;
import ipd.renade.renadeapi.repository.ICompetenciaRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.ICompetenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompetenciaServiceImpl extends CRUDImpl<Competencia,Integer> implements ICompetenciaService {

    private final ICompetenciaRepository competenciaRepository;

    @Override
    protected IGenericRepo<Competencia, Integer> getRepo() {
        return competenciaRepository;
    }
}
