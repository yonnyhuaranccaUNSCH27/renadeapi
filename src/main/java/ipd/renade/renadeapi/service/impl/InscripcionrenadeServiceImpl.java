package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.dto.OrganizacionAndInscripcionDTO;
import ipd.renade.renadeapi.model.Inscripcionrenade;
import ipd.renade.renadeapi.model.Resolucion;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IInscripcionrenadeRepository;
import ipd.renade.renadeapi.repository.IResolucionRepository;
import ipd.renade.renadeapi.service.IInscripcionrenadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InscripcionrenadeServiceImpl extends CRUDImpl<Inscripcionrenade,Integer> implements IInscripcionrenadeService {

    private final IInscripcionrenadeRepository inscripcionrenadeRepository;
    private final IResolucionRepository resolucionRepository;

    @Override
    protected IGenericRepo<Inscripcionrenade, Integer> getRepo() {
        return inscripcionrenadeRepository;
    }

    @Transactional
    @Override
    public Inscripcionrenade saveinscirpcionresolucion(Inscripcionrenade inscripcionrenade, Resolucion resolucion){

        Resolucion savedResolucion = resolucionRepository.save(resolucion);

        inscripcionrenade.setResolucion(savedResolucion);

        return inscripcionrenadeRepository.save(inscripcionrenade);
    }

    @Override
    public String getUltimoCodigo(String codigo) {
        return inscripcionrenadeRepository.findLastCodigo(codigo).orElse("00");

    }

    @Override
    public Page<Inscripcionrenade> listPage(Pageable pageable) {
        return inscripcionrenadeRepository.findActivosDesc(pageable);
    }



    @Override
    public boolean desactivarInscripcionrenade(Integer id) {
        int filasAfectadas=inscripcionrenadeRepository.desactivarInscripcion(id);
        return filasAfectadas>0;
    }

    @Override
    public Map<Integer, Long> findCountByTipoInsc() {
        
            List<Object[]> resultados = inscripcionrenadeRepository.findCountByTypeInscripcion();
            return getCountMap(resultados);
        
    }

    @Override
    public long totalInscripciones() {
        return inscripcionrenadeRepository.count();
    }

    @Override
    public List<OrganizacionAndInscripcionDTO> getOrgsAndInsc() {
        return inscripcionrenadeRepository.getOrgsAndInsc();
    }

    private Map<Integer, Long> getCountMap(List<Object[]> resultados) {
        Map<Integer, Long> conteos = new HashMap<>();

        for (Object[] resultado : resultados) {
            Integer id = (Integer) resultado[0];
            Long cantidad = (Long) resultado[1];
            conteos.put(id, cantidad);
        }
        return conteos;
    }
}
