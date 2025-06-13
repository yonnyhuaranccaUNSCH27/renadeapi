package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.model.Listarelacion;
import ipd.renade.renadeapi.model.Persona;
import ipd.renade.renadeapi.model.Ubigeo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IListarelacionService extends ICRUD<Listarelacion,Integer> {
    @Transactional
    Listarelacion saveListaRelacionPersona(Listarelacion listarelacion, Persona persona);

    List<Listarelacion> findAllByIdInscripcion(Integer idInscripcion);

    public List<Listarelacion> findAlldeportistas();

    long totalDep();
}
