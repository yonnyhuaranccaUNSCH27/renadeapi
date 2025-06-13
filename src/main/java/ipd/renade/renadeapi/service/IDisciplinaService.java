package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.model.Disciplina;
import ipd.renade.renadeapi.model.Inscripcionrenade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDisciplinaService extends ICRUD<Disciplina,Integer> {
    Page<Disciplina> listPage(Pageable pageable);
    long totalDisciplinas();
}
