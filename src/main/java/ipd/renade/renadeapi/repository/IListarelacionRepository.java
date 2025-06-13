package ipd.renade.renadeapi.repository;
import ipd.renade.renadeapi.model.Listarelacion;
import ipd.renade.renadeapi.model.Ubigeo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface IListarelacionRepository extends IGenericRepo<Listarelacion,Integer> {

    List<Listarelacion> findAllByInscripcionrenade_IdInscripcionrenade(Integer idInscripcion);

    @Query("SELECT l FROM Listarelacion l " +
            "JOIN FETCH l.persona p " +
            "JOIN FETCH l.disciplina d " +
            "JOIN FETCH l.inscripcionrenade i " +
            "WHERE i.tipoinscripcion.idTipoinscripcion IN (1, 4)")
    List<Listarelacion> findAlldeportistas();

    @Query(value = "SELECT COUNT(*) FROM tbl_listarelacion u " +
            "LEFT JOIN tbl_inscripcionrenade t ON u.id_inscripcionrenade = t.id_inscripcionrenade " +
            "WHERE t.id_tipoinscripcion IN (1, 4)", nativeQuery = true)
    long countdeportistas();
}
