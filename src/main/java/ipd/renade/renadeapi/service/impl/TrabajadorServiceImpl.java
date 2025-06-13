package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Organizacion;
import ipd.renade.renadeapi.model.Persona;
import ipd.renade.renadeapi.model.Resolucion;
import ipd.renade.renadeapi.model.Trabajador;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.ITrabajadorRepository;
import ipd.renade.renadeapi.service.ITrabajadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrabajadorServiceImpl extends CRUDImpl<Trabajador,Integer> implements ITrabajadorService {
    private final ITrabajadorRepository trabajadorRepository;

    @Override
    protected IGenericRepo<Trabajador, Integer> getRepo() {
        return trabajadorRepository;
    }



}
