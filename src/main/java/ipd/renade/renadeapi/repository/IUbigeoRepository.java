package ipd.renade.renadeapi.repository;
import ipd.renade.renadeapi.model.Ubigeo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface IUbigeoRepository extends IGenericRepo<Ubigeo,Integer> {
    @Query(value = "SELECT * FROM tbl_ubigeo u WHERE u.ubidpto= '00' and u.ubiprovincia = '00' and u.ubidiscrito='00'",nativeQuery = true)
    List<Ubigeo> findAllCountries() ;
    @Query(value = "SELECT * FROM tbl_ubigeo u WHERE u.ubiprovincia ='00' and u.ubidiscrito='00' ",nativeQuery = true)
    List<Ubigeo> findAllDepartments() ;

    @Query(value = "SELECT * FROM tbl_ubigeo u WHERE u.ubidiscrito = '00' and u.ubiprovincia!='00' and u.ubidpto=:departamento",nativeQuery = true)
    List<Ubigeo> findAllProviciaByDepartment(@Param("departamento") String departamento);

    @Query(value = "SELECT * FROM tbl_ubigeo u WHERE u.ubidiscrito!='00' and u.ubidpto =:departamento and u.ubiprovincia = :provincia",nativeQuery = true)
    List<Ubigeo> findAllDitritos(@Param("provincia") String provincia,@Param("departamento") String departamento);
}
