package ipd.renade.renadeapi.repository;

import ipd.renade.renadeapi.dto.OrganizacionAndInscripcionDTO;
import ipd.renade.renadeapi.model.Inscripcionrenade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface IInscripcionrenadeRepository extends IGenericRepo<Inscripcionrenade,Integer> {
    @Query("SELECT i FROM Inscripcionrenade i WHERE i.activo = true ORDER BY i.idInscripcionrenade DESC")
    Page<Inscripcionrenade> findActivosDesc(Pageable pageable);

    @Query("SELECT MAX(i.codigo) FROM Inscripcionrenade i WHERE i.sigla = :sigla")
    Optional<String> findLastCodigo(@Param("sigla") String sigla);

    @Modifying
    @Transactional
    @Query("UPDATE Inscripcionrenade i SET i.activo = false WHERE i.idInscripcionrenade = :id")
    int desactivarInscripcion(Integer id);

    @Query("""
    SELECT i.tipoinscripcion.idTipoinscripcion , COUNT(i.idInscripcionrenade)
    FROM Inscripcionrenade i
    GROUP BY i.tipoinscripcion.idTipoinscripcion
""")
    List<Object[]> findCountByTypeInscripcion();

    @Query(value = """
    SELECT new ipd.renade.renadeapi.dto.OrganizacionAndInscripcionDTO(
        e.sigla,
        e.codigo,
        e.ubigeo.ubidpto,
        e.ubigeo.ubiprovincia,
        e.ubigeo.ubidiscrito,
        e.resolucion.denominacion
    )
    FROM Inscripcionrenade e
    UNION ALL
    SELECT new ipd.renade.renadeapi.dto.OrganizacionAndInscripcionDTO(
        o.sigla,
        o.codigo,
        o.ubigeo.ubidpto,
        o.ubigeo.ubiprovincia,
        o.ubigeo.ubidiscrito,
        o.descDenominacion
    )
    FROM Organizacion o
    """)
    List<OrganizacionAndInscripcionDTO> getOrgsAndInsc();

}
