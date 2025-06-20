package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Categoria;
import ipd.renade.renadeapi.repository.ICategoriaRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.ICategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl extends CRUDImpl<Categoria,Integer> implements ICategoriaService {

    private final ICategoriaRepository categoriaRepository;

    @Override
    protected IGenericRepo<Categoria, Integer> getRepo() {
        return categoriaRepository;
    }
}
