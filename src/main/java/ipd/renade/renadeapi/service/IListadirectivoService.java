package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.dto.DirectivoDTO;
import ipd.renade.renadeapi.dto.ListadirectivoDTO;
import ipd.renade.renadeapi.model.Directivo;
import ipd.renade.renadeapi.model.Listadirectivo;

import java.util.List;

public interface IListadirectivoService extends ICRUD<Listadirectivo,Integer> {
    List<Listadirectivo> findByIdOrganizacion(Integer idOrganizacion);
    Listadirectivo saveDirectivo(ListadirectivoDTO listadirectivoDTO);
    Listadirectivo updateDirectivo(ListadirectivoDTO listadirectivoDTO);
    void deleteDirectivo(Integer IdListadirectivo);
}
