package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.dto.ResolucionNumeroDTO;
import ipd.renade.renadeapi.model.Resolucion;

import java.util.List;

public interface IResolucionService extends ICRUD<Resolucion,Integer> {
    List<Resolucion> findResolucionByOrganizacion(Integer idOrganizacion);
    List<ResolucionNumeroDTO> findResolucionNroByOrganizacion(Integer idOrganizacion);
    Resolucion saveResolucionOrganizacion(Integer idOrganizacion, Resolucion resolucion);
    void deleteResolucion(Integer IdResolucion);
}
