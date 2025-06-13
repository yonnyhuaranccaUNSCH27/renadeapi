package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.dto.OrganizacionPartidaDTO;
import ipd.renade.renadeapi.model.Partidaelectronica;
import java.util.List;
public interface IPartidaelectronicaService extends ICRUD<Partidaelectronica,Integer> {
    String getUltimoOrden(String numPartida,String numInscripcion);
    long totalPartidas();

    List<OrganizacionPartidaDTO> findOrganizacionesConPartidas();

    List<Partidaelectronica> findAllBySigla(String sigla,String codigo);
}