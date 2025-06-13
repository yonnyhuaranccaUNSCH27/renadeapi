package ipd.renade.renadeapi.repository;

import ipd.renade.renadeapi.model.Listaresolucion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IListaresolucionRepository extends IGenericRepo<Listaresolucion,Integer> {
    @Modifying
    @Query("DELETE FROM Listaresolucion lr WHERE lr.resolucion.idResolucion = :idResolucion")
    void deleteByIdResolucion(@Param("idResolucion") Integer idResolucion);

    List<Listaresolucion> findAllByOrganizacion_IdOrganizacion(Integer organizacionIdOrganizacion);

    @Query("""
        SELECT o.tipoorganizacion.idTipoorganizacion , COUNT(r.idListaresolucion)
        FROM Organizacion o
        LEFT JOIN o.listaresolucion r
        GROUP BY o.tipoorganizacion.idTipoorganizacion
    """)
    List<Object[]> findCountAllByIdTipoorganizacion();
}