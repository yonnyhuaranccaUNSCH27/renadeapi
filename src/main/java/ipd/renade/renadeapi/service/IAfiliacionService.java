package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.model.Afiliacion;

import ipd.renade.renadeapi.model.Afiliacion;

import java.util.List;

public interface IAfiliacionService extends ICRUD<Afiliacion,Integer> {
    public List<Afiliacion> findByOrgAfiliada(Integer idOrganizacion);
}
