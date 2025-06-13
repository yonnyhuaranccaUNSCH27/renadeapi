package ipd.renade.renadeapi.repository;

import ipd.renade.renadeapi.model.Listaresolucion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IOrganizacionListResRepository extends IGenericRepo<Listaresolucion,Integer>{

    //@Transactional
    @Modifying
    @Query(value = "INSERT INTO tbl_listaresolucion(id_resolucion,id_organizacion) VALUES (:id_resolucion,:id_organizacion)",nativeQuery = true)
    Integer saveResolucion(@Param("id_resolucion") Integer id_resolucion,@Param("id_organizacion") Integer id_organizacion);
}
