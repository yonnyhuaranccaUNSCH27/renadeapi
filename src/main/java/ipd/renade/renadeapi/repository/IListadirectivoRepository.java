package ipd.renade.renadeapi.repository;

import ipd.renade.renadeapi.model.Listadirectivo;
import ipd.renade.renadeapi.model.Organizacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IListadirectivoRepository extends IGenericRepo<Listadirectivo,Integer> {
    @Query("SELECT ld FROM Listadirectivo ld WHERE ld.organizacion.idOrganizacion = :idOrganizacion ORDER BY ld.idListadirectivo DESC")
    List<Listadirectivo> findByIdOrganizacion(@Param("idOrganizacion") Integer idOrganizacion);

}
