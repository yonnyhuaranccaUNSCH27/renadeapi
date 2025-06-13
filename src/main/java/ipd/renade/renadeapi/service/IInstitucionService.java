package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.model.Institucion;

import java.util.List;

public interface IInstitucionService extends ICRUD<Institucion,Integer> {
    public List<Institucion> getxmundoc(Integer tipoidentidad, String numdocumento) ;
}
