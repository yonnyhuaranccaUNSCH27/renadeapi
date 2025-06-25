package ipd.renade.renadeapi.repository;

import ipd.renade.renadeapi.model.Actividad;

import java.util.List;

public interface IActividadRepository extends IGenericRepo<Actividad, Integer> {
    List<Actividad> findByTitulo(String titulo);
}
