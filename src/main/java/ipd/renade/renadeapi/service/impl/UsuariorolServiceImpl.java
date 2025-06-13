package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Trabajador;
import ipd.renade.renadeapi.model.Usuariorol;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IUsuariorolRepository;
import ipd.renade.renadeapi.service.ITrabajadorService;
import ipd.renade.renadeapi.service.IUsuariorolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuariorolServiceImpl extends CRUDImpl<Usuariorol,Integer> implements IUsuariorolService {
    private final IUsuariorolRepository usuariorolrepository;

    @Override
    protected IGenericRepo<Usuariorol,Integer> getRepo() {
        return usuariorolrepository;
    }
}
