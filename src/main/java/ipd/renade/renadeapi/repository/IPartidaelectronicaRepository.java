package ipd.renade.renadeapi.repository;

import ipd.renade.renadeapi.dto.OrganizacionPartidaDTO;
import ipd.renade.renadeapi.model.Partidaelectronica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;
public interface IPartidaelectronicaRepository extends IGenericRepo<Partidaelectronica,Integer> {
    @Query("SELECT MAX(p.numOrden) FROM Partidaelectronica p WHERE p.numPartida = :numPartida and p.numInscripcion=:numInscripcion")
    Optional<String> findNumByNumPartida(@Param("numPartida") String numPartida,@Param("numInscripcion") String numInscripcion );

    @Query("""
SELECT new ipd.renade.renadeapi.dto.OrganizacionPartidaDTO(
            i.resolucion.numExpediente,
            pe)
            FROM Inscripcionrenade i
            JOIN Partidaelectronica pe ON i.codigo = pe.numInscripcion AND i.sigla = pe.numPartida
                UNION ALL
            SELECT new ipd.renade.renadeapi.dto.OrganizacionPartidaDTO(
            o.descDenominacion,
            pe)
            FROM Organizacion o
            JOIN Partidaelectronica pe ON o.codigo = pe.numInscripcion AND o.sigla = pe.numPartida
            ORDER BY pe.idPartidaelectronica DESC
""")
    List<OrganizacionPartidaDTO> findOrganizacionesConPartidas();

    @Query("""
    SELECT pe
    FROM Partidaelectronica pe
    WHERE pe.numPartida =:sigla and pe.numInscripcion=:codigo
    ORDER BY pe.idPartidaelectronica DESC
""")
    List<Partidaelectronica> findPartidasBySigla(@Param("sigla") String sigla,@Param("codigo") String codigo);


}