package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Institucion;
import ipd.renade.renadeapi.repository.IInstitucionRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IInstitucionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstitucionServiceImpl extends CRUDImpl<Institucion,Integer> implements IInstitucionService {

    private final IInstitucionRepository institucionRepository;

    @Override
    protected IGenericRepo<Institucion, Integer> getRepo() {
        return institucionRepository;
    }

    @Override
    public List<Institucion> getxmundoc(Integer tipoidentidad, String numdocumento) {
        return  institucionRepository.findAllNumdoc(tipoidentidad,numdocumento);
    }
}
