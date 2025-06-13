package ipd.renade.renadeapi.repository;

import ipd.renade.renadeapi.model.Afiliacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAfiliacionRepository extends IGenericRepo<Afiliacion, Integer> {
    @Query("SELECT a FROM Afiliacion a WHERE a.organizacionAfiliada.idOrganizacion = :idOrganizacion ORDER BY a.idAfiliacion DESC")
    public List<Afiliacion> findByIdOrganizacionAfiliada(@Param("idOrganizacion") Integer idOrganizacion);
}
