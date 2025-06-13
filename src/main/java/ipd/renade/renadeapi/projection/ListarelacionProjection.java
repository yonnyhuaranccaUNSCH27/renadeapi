package ipd.renade.renadeapi.projection;
import java.util.Date;

public interface ListarelacionProjection {
    Integer getIdListarelacion();
    String getDescripcion();
    Integer getEstado();

    PersonaProjection getPersona();
    DisciplinaProjection getDisciplina();
    InscripcionrenadeProjection getInscripcionrenade();

    interface PersonaProjection {
        Integer getIdPersona();
        String getPerNumdocumento();
        String getPerNombres();
        String getApePaterno();
        String getApeMaterna();
        Integer getPerGenero();
        String getPerDireccion();
        String getPerTelefono();
        String getPerCorreo();
        Date getPerFechanacimiento();
        UbigeoProjection getUbigeo();
        TipoidentidadProjection getTipoidentidad();

        interface UbigeoProjection {
            Integer getIdUbigeo();
            String getDescripcion();
        }

        interface TipoidentidadProjection {
            Integer getIdTipoidentidad();
            String getDescripcion();
        }
    }

    interface DisciplinaProjection {
        Integer getIdDisciplina();
        String getCodigo();
        String getDescripcion();
    }

    interface InscripcionrenadeProjection {
        Integer getIdInscripcionrenade();
        String getMotivo();
        String getObservacion();
        TipoinscripcionProjection getTipoinscripcion();
        ResolucionProjection getResolucion();
        TipoagenteProjection getTipoagente();

        interface TipoinscripcionProjection {
            Integer getIdTipoinscripcion();
            String getDescripcion();
        }

        interface ResolucionProjection {
            Integer getIdResolucion();
            String getNumero();
        }

        interface TipoagenteProjection {
            Integer getIdTipoagente();
            String getDescripcion();
        }
    }
}
