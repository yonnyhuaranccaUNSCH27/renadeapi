package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.dto.OrganizacionAndInscripcionDTO;
import ipd.renade.renadeapi.model.Inscripcionrenade;
import ipd.renade.renadeapi.model.Resolucion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface IInscripcionrenadeService extends ICRUD<Inscripcionrenade,Integer> {

    @Transactional
    Inscripcionrenade saveinscirpcionresolucion(Inscripcionrenade inscripcionrenade, Resolucion resolucion);

    //List<Inscripcionrenade> findAllActivos();

    String getUltimoCodigo(String numPartida);
    Page<Inscripcionrenade> listPage(Pageable pageable);

    boolean desactivarInscripcionrenade(Integer id);
    Map<Integer, Long> findCountByTipoInsc() ;

    long totalInscripciones();

    List<OrganizacionAndInscripcionDTO> getOrgsAndInsc();
}
