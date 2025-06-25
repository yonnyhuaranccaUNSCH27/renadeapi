package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.model.Actividad;

import java.util.List;

public interface IActividadService extends ICRUD<Actividad,Integer> {
    public List<Actividad> findByTitulo(String titulo);
}
