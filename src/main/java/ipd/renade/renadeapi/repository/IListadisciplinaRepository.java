package ipd.renade.renadeapi.repository;

import ipd.renade.renadeapi.model.Listadisciplina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IListadisciplinaRepository extends IGenericRepo<Listadisciplina,Integer> {
    @Query("SELECT ld FROM Listadisciplina ld WHERE ld.organizacion.idOrganizacion = :idOrganizacion ORDER BY ld.idListadisciplina DESC")
    List<Listadisciplina> findAllByOrganizacion_IdOrganizacionDesc(@Param("idOrganizacion") Integer idOrganizacion);
}