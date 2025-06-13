package ipd.renade.renadeapi.repository;
import ipd.renade.renadeapi.dto.ListapartidaelectronicaResDTO;
import ipd.renade.renadeapi.model.Listapartidaelectronica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface IListapartidaelectronicaRepository extends IGenericRepo<Listapartidaelectronica,Integer> {
    @Query("""
            SELECT new ipd.renade.renadeapi.dto.ListapartidaelectronicaResDTO(
             lpe.idListapartidaelectronica,
             lpe.descripcion,
             r.numResrenade,
             pe.numPartida,
             r.idResolucion,
             pe.idPartidaelectronica,
         pe.numInscripcion,
         pe.numOrden,
         pe.codUbigeo,
         pe.codDisciplina
                             )
             FROM Listapartidaelectronica lpe
             LEFT JOIN lpe.resolucion r
             LEFT JOIN lpe.partidaelectronica pe
             WHERE r.idResolucion = :idResolucion
        """)
    List<ListapartidaelectronicaResDTO> findByIdResolucion(@Param("idResolucion") Integer idResolucion);

    @Query("""
        SELECT new ipd.renade.renadeapi.dto.ListapartidaelectronicaResDTO(
         lpe.idListapartidaelectronica,
         lpe.descripcion,
         r.numResrenade,
         pe.numPartida,
         r.idResolucion,
         pe.idPartidaelectronica,
         pe.numInscripcion,
         pe.numOrden,
         pe.codUbigeo,
         pe.codDisciplina
         )
         FROM Listapartidaelectronica lpe
         INNER JOIN lpe.resolucion r
         INNER JOIN r.listaresoluciones lr
         LEFT JOIN lpe.partidaelectronica pe
         WHERE lr.organizacion.idOrganizacion = :organizacionId
    """)
    List<ListapartidaelectronicaResDTO> findByOrganizacionId(@Param("organizacionId") Integer organizacionId);

}