package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Grado;
import ipd.renade.renadeapi.repository.IGradoRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IGradoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradoServiceImpl extends CRUDImpl<Grado,Integer> implements IGradoService {

    private final IGradoRepository gradoRepository;

    @Override
    protected IGenericRepo<Grado, Integer> getRepo() {
        return gradoRepository;
    }
}
