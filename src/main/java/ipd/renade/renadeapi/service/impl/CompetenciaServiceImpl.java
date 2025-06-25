package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.dto.IMedallasPorAlumnoDTO;
import ipd.renade.renadeapi.dto.IResultadoMedallaDTO;
import ipd.renade.renadeapi.model.Competencia;
import ipd.renade.renadeapi.model.Ubigeo;
import ipd.renade.renadeapi.repository.ICompetenciaRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.ICompetenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetenciaServiceImpl extends CRUDImpl<Competencia,Integer> implements ICompetenciaService {

    private final ICompetenciaRepository competenciaRepository;

    @Override
    protected IGenericRepo<Competencia, Integer> getRepo() {
        return competenciaRepository;
    }

    // Cambia el tipo de retorno aquí:
    @Override
    public List<IResultadoMedallaDTO> countAllByAno() {
        return competenciaRepository.countAllByAno();
    }

    @Override
    public List<Competencia> listarPorAno(Integer idAnos) {
        return competenciaRepository.findByAnos_IdAnos(idAnos);
    }

    @Override
    public List<Competencia> listarPorAlumnoBy(Integer idAlumno) {
        return competenciaRepository.findByAlumno_IdAlumno(idAlumno);
    }

    @Override
    public List<IResultadoMedallaDTO> countAllByAnolista(Integer anio) {
        return competenciaRepository.countAllByAnolista(anio);
    }

    @Override
    public List<IMedallasPorAlumnoDTO> listarPorAlumno() {
        return competenciaRepository.listarMedallasPorAlumno();
    }

}
