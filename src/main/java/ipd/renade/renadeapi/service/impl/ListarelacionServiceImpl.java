package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Listarelacion;
import ipd.renade.renadeapi.model.Persona;
import ipd.renade.renadeapi.model.Ubigeo;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IListarelacionRepository;
import ipd.renade.renadeapi.repository.IPersonaRepository;
import ipd.renade.renadeapi.service.IListarelacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarelacionServiceImpl extends CRUDImpl<Listarelacion,Integer> implements IListarelacionService {

    private final IListarelacionRepository listarelacionRepository;
    private final IPersonaRepository personaRepository;
    @Override
    protected IGenericRepo<Listarelacion, Integer> getRepo() {
        return listarelacionRepository;
    }

    @Transactional
    @Override
    public Listarelacion saveListaRelacionPersona(Listarelacion listarelacion,Persona persona) {
        Persona personaSaved=personaRepository.save(persona);
        listarelacion.setPersona(personaSaved);
        return listarelacionRepository.save(listarelacion);
    }

    @Override
    public List<Listarelacion> findAllByIdInscripcion(Integer idInscripcion) {
       return listarelacionRepository.findAllByInscripcionrenade_IdInscripcionrenade(idInscripcion);
    }

    @Override
    public List<Listarelacion> findAlldeportistas() {
        return listarelacionRepository.findAlldeportistas();
    }

    @Override
    public long totalDep() {
        return listarelacionRepository.countdeportistas();
    }
}
