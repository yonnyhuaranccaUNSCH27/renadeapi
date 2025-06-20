package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Gradoinstruccion;
import ipd.renade.renadeapi.repository.IGradoinstruccionRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IGradoinstruccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradoinstruccionServiceImpl extends CRUDImpl<Gradoinstruccion,Integer> implements IGradoinstruccionService {

    private final IGradoinstruccionRepository gradoinstruccionRepository;

    @Override
    protected IGenericRepo<Gradoinstruccion, Integer> getRepo() {
        return gradoinstruccionRepository;
    }
}
