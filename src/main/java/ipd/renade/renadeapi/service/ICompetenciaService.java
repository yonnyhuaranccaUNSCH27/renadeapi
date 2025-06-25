package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.dto.IMedallasPorAlumnoDTO;
import ipd.renade.renadeapi.dto.IResultadoMedallaDTO;
import ipd.renade.renadeapi.model.Competencia;
import ipd.renade.renadeapi.model.Ubigeo;

import java.util.List;

public interface ICompetenciaService extends ICRUD<Competencia,Integer> {
    List<IResultadoMedallaDTO> countAllByAno();
    List<Competencia> listarPorAno(Integer idAnos);
    List<Competencia> listarPorAlumnoBy(Integer idAlumno);
    List<IResultadoMedallaDTO> countAllByAnolista(Integer anio);
    List<IMedallasPorAlumnoDTO> listarPorAlumno();
}
