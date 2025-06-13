package ipd.renade.renadeapi.repository;

import ipd.renade.renadeapi.dto.ResolucionNumeroDTO;
import ipd.renade.renadeapi.model.Resolucion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IResolucionRepository extends IGenericRepo<Resolucion,Integer> {
    @Query("SELECT r FROM Resolucion r JOIN r.listaresoluciones lr WHERE lr.organizacion.idOrganizacion = :idOrganizacion ORDER BY r.idResolucion DESC")
    List<Resolucion> findResolucionByOrganizacion(@Param("idOrganizacion") Integer idOrganizacion);

    @Query("SELECT new ipd.renade.renadeapi.dto.ResolucionNumeroDTO(r.idResolucion,r.numExpediente) FROM Resolucion r JOIN r.listaresoluciones lr WHERE lr.organizacion.idOrganizacion = :idOrganizacion ORDER BY r.idResolucion DESC")
    List<ResolucionNumeroDTO> findResolucionNroByOrganizacion(@Param("idOrganizacion") Integer idOrganizacion);
}