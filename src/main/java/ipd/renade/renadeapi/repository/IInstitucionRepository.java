package ipd.renade.renadeapi.repository;

import ipd.renade.renadeapi.model.Institucion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IInstitucionRepository extends IGenericRepo<Institucion, Integer> {
    @Query(value = "SELECT * FROM tbl_institucion a WHERE a.numdocumento =:numdocumento AND a.id_tipoidentidad =:tipoidentidad ;", nativeQuery = true)
    List<Institucion> findAllNumdoc(@Param("tipoidentidad") Integer tipoidentidad, @Param("numdocumento") String numdocumento);
}
