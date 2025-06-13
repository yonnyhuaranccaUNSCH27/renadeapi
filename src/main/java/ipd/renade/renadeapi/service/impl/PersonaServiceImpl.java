package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.dto.PersonaDocumentoDTO;
import ipd.renade.renadeapi.model.Persona;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IPersonaRepository;
import ipd.renade.renadeapi.service.IPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl extends CRUDImpl<Persona,Integer> implements IPersonaService {
    private final IPersonaRepository personaRepository;

    @Override
    protected IGenericRepo<Persona, Integer> getRepo() {
        return personaRepository;
    }

    @Override
    public List<PersonaDocumentoDTO> findByIdTipoIdentidad(Integer idTipoIdentidad) {
        return this.personaRepository.findByIdTipoIdentidad(idTipoIdentidad);
    }

    @Override
    public List<Persona> getxmundoc(Integer tipodocumento, String numdocumento) {
        return  personaRepository.findAllNumdoc(tipodocumento,numdocumento);
    }
}
