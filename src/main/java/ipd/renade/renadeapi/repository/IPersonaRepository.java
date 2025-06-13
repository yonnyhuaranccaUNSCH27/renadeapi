package ipd.renade.renadeapi.repository;

import ipd.renade.renadeapi.dto.PersonaDocumentoDTO;
import ipd.renade.renadeapi.model.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPersonaRepository extends IGenericRepo<Persona,Integer> {
    @Query("SELECT NEW ipd.renade.renadeapi.dto.PersonaDocumentoDTO(p.idPersona, p.perNumdocumento) FROM Persona p WHERE p.tipoidentidad.idTipoidentidad = :idTipoIdentidad")
    List<PersonaDocumentoDTO> findByIdTipoIdentidad(@Param("idTipoIdentidad") Integer idTipoIdentidad);

    @Query(value = "SELECT * FROM tbl_persona a WHERE a.per_numdocumento =:numdocumento AND a.id_tipoidentidad =:tipodocumento ;", nativeQuery = true)
    List<Persona> findAllNumdoc(@Param("tipodocumento") Integer tipodocumento,@Param("numdocumento") String numdocumento);
}
