package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.dto.ListadirectivoDTO;
import ipd.renade.renadeapi.model.*;
import ipd.renade.renadeapi.repository.IFuncionesRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IListadirectivoRepository;
import ipd.renade.renadeapi.service.*;
import ipd.renade.renadeapi.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListadirectivoServiceImpl extends CRUDImpl<Listadirectivo,Integer> implements IListadirectivoService {
    private final MapperUtil mapperUtil;
    private final IListadirectivoRepository listadirectivoRepository;
    private final IDirectivoService directivoService;
    private final IPersonaService personaService;
    private final IOrganizacionService organizacionService;
    private final IFuncionesService funcionesService;
    private final IFuncionesRepository funcionesRepository;
    private final ITipoidentidadService tipoidentidadService;
    private final IUbigeoService ubigeoService;
    private final IResolucionService resolucionService;

    @Override
    protected IGenericRepo<Listadirectivo, Integer> getRepo() {
        return listadirectivoRepository;
    }

    @Override
    public List<Listadirectivo> findByIdOrganizacion(Integer idOrganizacion) {
        return listadirectivoRepository.findByIdOrganizacion(idOrganizacion);
    }

    @Transactional
    @Override
    public Listadirectivo saveDirectivo(ListadirectivoDTO ldDTO) {
        System.out.println(ldDTO.getIdOrganizacion());
        System.out.println(ldDTO.getDirectivo().getIdFunciones());
        System.out.println(ldDTO.getDirectivo().getPersona().getIdTipoidentidad());
        System.out.println(ldDTO.getDirectivo().getPersona().getIdUbigeo());

        //Completando datos no reconocidos por ModelMapper

        Listadirectivo ld = mapperUtil.map(ldDTO, Listadirectivo.class);//No reconoce ID Organizacion.
        ld.setOrganizacion(organizacionService.findById(ldDTO.getIdOrganizacion()));

        Directivo d = ld.getDirectivo(); //No reconoce idFunciones
        d.setFunciones(funcionesService.findById(ldDTO.getDirectivo().getIdFunciones()));

        Persona p = d.getPersona(); //No reconoce idTipoidentidad, idUbigeo;
        p.setTipoidentidad( tipoidentidadService.findById(ldDTO.getDirectivo().getPersona().getIdTipoidentidad()));
        Ubigeo ubigeo = (ldDTO.getDirectivo().getPersona().getIdUbigeo()==null)
                ?null
                :ubigeoService.findById(ldDTO.getDirectivo().getPersona().getIdUbigeo());
        p.setUbigeo(ubigeo);


        //Guardar Persona
        p = personaService.save(p);

        //Guardar Directivo
        d.setPersona(p);
        d = directivoService.save(d);
        //Asignar fechaInicio y fechaFinal desde al Resolución asociada.
        Resolucion r = resolucionService.findById(ldDTO.getResolucion().getIdResolucion());
        d.setFechaInicio(r.getFechaInicio());
        d.setFechaFinal(r.getFechaFin());

        //Guardar Listadirectivo;
        ld.setDirectivo(d);


        //Guardar y retornar Listadirectivo guardado
        return listadirectivoRepository.save(ld);
    }

    @Transactional
    @Override
    public Listadirectivo updateDirectivo(ListadirectivoDTO ldDTO) {

        //Completando datos no reconocidos por ModelMapper

        Listadirectivo ld = mapperUtil.map(ldDTO, Listadirectivo.class);//No reconoce ID Organizacion.
        ld.setOrganizacion(organizacionService.findById(ldDTO.getIdOrganizacion()));

        Directivo d = ld.getDirectivo(); //No reconoce idFunciones
        d.setFunciones(funcionesService.findById(ldDTO.getDirectivo().getIdFunciones()));

        Persona p = d.getPersona(); //No reconoce idTipoidentidad, idUbigeo;
        p.setTipoidentidad( tipoidentidadService.findById(ldDTO.getDirectivo().getPersona().getIdTipoidentidad()));
        Ubigeo ubigeo = (ldDTO.getDirectivo().getPersona().getIdUbigeo()==null)
                ?null
                :ubigeoService.findById(ldDTO.getDirectivo().getPersona().getIdUbigeo());
        p.setUbigeo(ubigeo);


        //Guardar Persona
        p = personaService.update(p.getIdPersona(),p);

        //Guardar Directivo
        d.setPersona(p);
        d = directivoService.update(d.getIdDirectivo(),d);
        //Asignar fechaInicio y fechaFinal desde al Resolución asociada.
        Resolucion r = resolucionService.findById(ldDTO.getResolucion().getIdResolucion());
        d.setFechaInicio(r.getFechaInicio());
        d.setFechaFinal(r.getFechaFin());

        //Guardar Listadirectivo;
        ld.setDirectivo(d);


        //Guardar y retornar Listadirectivo guardado
        return listadirectivoRepository.save(ld);
    }

    @Transactional
    @Override
    public void deleteDirectivo(Integer IdListadirectivo) {
        Optional<Listadirectivo> obj = listadirectivoRepository.findById(IdListadirectivo);
        this.listadirectivoRepository.deleteById(obj.get().getIdListadirectivo());
        this.directivoService.delete(obj.get().getDirectivo().getIdDirectivo());
        //this.personaService.delete(obj.get().getDirectivo().getPersona().getIdPersona());
    }
}
