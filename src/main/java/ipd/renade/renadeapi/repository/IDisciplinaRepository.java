package ipd.renade.renadeapi.repository;
import ipd.renade.renadeapi.model.Disciplina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDisciplinaRepository extends IGenericRepo<Disciplina,Integer> {
    public Page<Disciplina> findAll(Pageable pageable);
}
