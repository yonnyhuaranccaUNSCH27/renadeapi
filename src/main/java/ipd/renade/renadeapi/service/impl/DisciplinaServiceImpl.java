package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Disciplina;
import ipd.renade.renadeapi.repository.IDisciplinaRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IDisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DisciplinaServiceImpl extends CRUDImpl<Disciplina,Integer> implements IDisciplinaService {

    private final IDisciplinaRepository disciplinaRepository;

    @Override
    protected IGenericRepo<Disciplina, Integer> getRepo() {
        return disciplinaRepository;
    }

    @Override
    public Page<Disciplina> listPage(Pageable pageable) {
        return disciplinaRepository.findAll(pageable);
    }

    @Override
    public long totalDisciplinas() {
        return disciplinaRepository.count();
    }
}
