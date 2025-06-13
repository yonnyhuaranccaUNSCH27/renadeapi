package ipd.renade.renadeapi.repository;

import ipd.renade.renadeapi.dto.OrganizacionAfiliadoraDTO;
import ipd.renade.renadeapi.dto.OrganizacionResumenDTO;
import ipd.renade.renadeapi.dto.OrganizacionTablaDTO;
import ipd.renade.renadeapi.dto.ResolucionNumeroDTO;
import ipd.renade.renadeapi.model.Organizacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrganizacionRepository extends IGenericRepo<Organizacion,Integer> {
    @Query("Select o FROM Organizacion o WHERE o.tipoorganizacion.idTipoorganizacion = :idTipoorganizacion ORDER BY o.idOrganizacion DESC")
    List<Organizacion> findByIdTipoorganizacion(@Param("idTipoorganizacion") Integer idTipoorganizacion);

    @Query("""
    SELECT o.tipoorganizacion.idTipoorganizacion , COUNT(o.idOrganizacion)
    FROM Organizacion o
    GROUP BY o.tipoorganizacion.idTipoorganizacion
""")
    List<Object[]> findCountByTypeOrganizacion();

    Organizacion findFirstBySiglaOrderByCodigoDesc(String sigla);

    @Query("""
    SELECT o.tipoliga.idTipoliga , COUNT(o.idOrganizacion)
    FROM Organizacion o
    WHERE o.tipoorganizacion.idTipoorganizacion = 2
    GROUP BY o.tipoliga.idTipoliga
""")//id de las ligas=2
    List<Object[]> findCountByTypeLiga();

    @Query("SELECT new ipd.renade.renadeapi.dto.OrganizacionAfiliadoraDTO(o.idOrganizacion, o.descDenominacion) FROM Organizacion o WHERE o.idOrganizacion <> :idOrganizacion AND o.tipoorganizacion.idTipoorganizacion <> 1 AND o.tipoorganizacion.idTipoorganizacion <> 4 AND o.estado = 1")
    List<OrganizacionAfiliadoraDTO> findAllOrgAfiliadora(@Param("idOrganizacion") Integer idOrganizacion);

    @Query("""
       SELECT new ipd.renade.renadeapi.dto.OrganizacionTablaDTO(
       o.idOrganizacion,
       o.descDenominacion,
       o.sigla,
       o.codigo,
       i.descripcion,
       tl.descripcion,
       d.denominacion,
       p.denominacion,
       o.ubigeo.denominacion,
       o.direccion,
       o.telefono
       )
       FROM Organizacion o
       LEFT JOIN o.institucion i
       LEFT JOIN o.tipoliga tl
       JOIN Ubigeo d
       ON d.ubipais = o.ubigeo.ubipais AND d.ubidpto = o.ubigeo.ubidpto AND d.ubiprovincia = '00' AND d.ubidiscrito = '00'
       JOIN Ubigeo p
       ON p.ubipais = o.ubigeo.ubipais AND p.ubidpto = o.ubigeo.ubidpto AND p.ubiprovincia = o.ubigeo.ubiprovincia AND p.ubidiscrito = '00'
       WHERE o.tipoorganizacion.idTipoorganizacion = :idTipoorganizacion
       ORDER BY  o.idOrganizacion DESC
    """)
    List<OrganizacionTablaDTO> getInfoOrgForTable(@Param("idTipoorganizacion") Integer idTipoorganizacion);

    @Query("""
       SELECT new ipd.renade.renadeapi.dto.OrganizacionTablaDTO(
       o.idOrganizacion,
       o.descDenominacion,
       o.sigla,
       o.codigo,
       i.descripcion,
       tl.descripcion,
       d.denominacion,
       p.denominacion,
       o.ubigeo.denominacion,
       o.direccion,
       o.telefono
       )
       FROM Organizacion o
       LEFT JOIN o.institucion i
       LEFT JOIN o.tipoliga tl
       JOIN Ubigeo d
       ON d.ubipais = o.ubigeo.ubipais AND d.ubidpto = o.ubigeo.ubidpto AND d.ubiprovincia = '00' AND d.ubidiscrito = '00'
       JOIN Ubigeo p
       ON p.ubipais = o.ubigeo.ubipais AND p.ubidpto = o.ubigeo.ubidpto AND p.ubiprovincia = o.ubigeo.ubiprovincia AND p.ubidiscrito = '00'
       WHERE o.tipoorganizacion.idTipoorganizacion = :idTipoorganizacion AND o.estado != 0
       ORDER BY  o.idOrganizacion DESC
    """)
    Page<OrganizacionTablaDTO> findOrgByTipoForTable(@Param("idTipoorganizacion") Integer idTipoorganizacion, Pageable pageable);

    @Query("""
       SELECT new ipd.renade.renadeapi.dto.OrganizacionResumenDTO(
       o.idOrganizacion,
       CONCAT(o.sigla,o.codigo),
       o.descDenominacion,
       o.descripcion,
       i.descripcion,
       tl.descripcion,
       d.denominacion,
       p.denominacion,
       o.ubigeo.denominacion,
       o.correo,
       o.direccion,
       o.telefono,
       o.fechaRegistro,
       o.fechaInicioactividad,
       o.tipoorganizacion.idTipoorganizacion
       )
       FROM Organizacion o
       LEFT JOIN o.institucion i
       LEFT JOIN o.tipoliga tl
       JOIN Ubigeo d
       ON d.ubipais = o.ubigeo.ubipais AND d.ubidpto = o.ubigeo.ubidpto AND d.ubiprovincia = '00' AND d.ubidiscrito = '00'
       JOIN Ubigeo p
       ON p.ubipais = o.ubigeo.ubipais AND p.ubidpto = o.ubigeo.ubidpto AND p.ubiprovincia = o.ubigeo.ubiprovincia AND p.ubidiscrito = '00'
       WHERE o.idOrganizacion = :idOrganizacion
    """)
    OrganizacionResumenDTO findResumenOrgById(@Param("idOrganizacion") Integer idOrganizacion);

    @Modifying
    @Query("UPDATE Organizacion o SET o.estado = 0 WHERE o.idOrganizacion = :idOrganizacion")
    void deshabilitarOrganizacion(@Param("idOrganizacion") Integer idOrganizacion);

    @Query("SELECT MAX(CAST(o.codigo AS int)) + 1 FROM Organizacion o WHERE o.sigla = :sigla")
    Integer generarCodigoEntero(@Param("sigla") String sigla);

    Organizacion findBySiglaAndCodigo(@Param("sigla") String sigla, @Param("codigo") String codigo);
}