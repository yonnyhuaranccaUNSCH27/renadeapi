package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.dto.PersonaDocumentoDTO;
import ipd.renade.renadeapi.model.Persona;

import java.util.List;

public interface IPersonaService extends ICRUD<Persona,Integer> {
    List<PersonaDocumentoDTO> findByIdTipoIdentidad(Integer idTipoIdentidad);
    public List<Persona> getxmundoc(Integer tipodocumento, String numdocumento);
}
