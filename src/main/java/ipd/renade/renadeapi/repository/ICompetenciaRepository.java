package ipd.renade.renadeapi.repository;

import ipd.renade.renadeapi.dto.IMedallasPorAlumnoDTO;
import ipd.renade.renadeapi.dto.IResultadoMedallaDTO;
import ipd.renade.renadeapi.model.Competencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICompetenciaRepository extends IGenericRepo<Competencia, Integer> {

    @Query(value = """ 
        SELECT 
            c.id_anos AS id_anos,
            a.descripcion AS descripcion,
            COUNT(*) AS totalmedallas,
            SUM(CASE WHEN c.id_merito = 1 THEN 1 ELSE 0 END) AS totaloro,
            SUM(CASE WHEN c.id_merito = 2 THEN 1 ELSE 0 END) AS totalplata,
            SUM(CASE WHEN c.id_merito = 3 THEN 1 ELSE 0 END) AS totalbronce
        FROM cede.tbl_competencia c
        INNER JOIN cede.tbl_anos a ON c.id_anos = a.id_anos
        GROUP BY c.id_anos, a.descripcion
        ORDER BY c.id_anos DESC
    """, nativeQuery = true)
    List<IResultadoMedallaDTO> countAllByAno();

    @Query(value = """
        SELECT 
            c.id_anos AS id_anos,
            a.descripcion AS descripcion,
            COUNT(*) AS totalmedallas,
            SUM(CASE WHEN c.id_merito = 1 THEN 1 ELSE 0 END) AS totaloro,
            SUM(CASE WHEN c.id_merito = 2 THEN 1 ELSE 0 END) AS totalplata,
            SUM(CASE WHEN c.id_merito = 3 THEN 1 ELSE 0 END) AS totalbronce
        FROM cede.tbl_competencia c
        INNER JOIN cede.tbl_anos a ON c.id_anos = a.id_anos
        WHERE a.descripcion = :anio
        GROUP BY c.id_anos, a.descripcion
        ORDER BY c.id_anos
    """, nativeQuery = true)
    List<IResultadoMedallaDTO> countAllByAnolista(@Param("anio") Integer anio);


    List<Competencia> findByAnos_IdAnos(Integer idAnos);

    List<Competencia> findByAlumno_IdAlumno(Integer idAlumnos);

    @Query(value = "SELECT " +
            "a.id_alumno AS idAlumno, " +
            "p.per_nombres AS nombres, " +
            "CONCAT(p.ape_paterno, ' ', p.ape_materna) AS apellidos, " +
            "a.urlfoto AS foto, " +
            "d.descripcion AS disciplina, " +
            "g.descripcion AS grado, " +
            "n.descripcion AS nivel, " +
            "p.per_genero AS genero, " +
            "SUM(CASE WHEN m.descripcion = 'ORO' THEN 1 ELSE 0 END) AS totalOro, " +
            "SUM(CASE WHEN m.descripcion = 'PLATA' THEN 1 ELSE 0 END) AS totalPlata, " +
            "SUM(CASE WHEN m.descripcion = 'BRONCE' THEN 1 ELSE 0 END) AS totalBronce " +
            "FROM cede.tbl_competencia c " +
            "JOIN cede.tbl_alumno a ON c.id_alumno = a.id_alumno " +
            "JOIN dbo.tbl_persona p ON a.id_persona = p.id_persona " +
            "JOIN cede.tbl_merito m ON c.id_merito = m.id_merito " +
            "JOIN dbo.tbl_disciplina d ON c.id_disciplina = d.id_disciplina " +
            "JOIN cede.tbl_grado g ON c.id_grado = g.id_grado " +
            "JOIN cede.tbl_niveleducacion n ON g.id_niveleducacion = n.id_niveleducacion " +
            "GROUP BY a.id_alumno, p.per_nombres, p.ape_paterno, p.ape_materna,p.per_genero, a.urlfoto, d.descripcion, g.descripcion, n.descripcion " +
            "ORDER BY MAX(c.id_competencia) DESC",
            nativeQuery = true)
    List<IMedallasPorAlumnoDTO> listarMedallasPorAlumno();


}
