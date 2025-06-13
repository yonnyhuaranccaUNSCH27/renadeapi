package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.exception.ModelNotFoundException;
import ipd.renade.renadeapi.model.Usuario;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IUsuarioRepository;
import ipd.renade.renadeapi.service.IUsuarioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends CRUDImpl<Usuario,Integer> implements IUsuarioService {
    private final IUsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    protected IGenericRepo<Usuario, Integer> getRepo() {
        return usuarioRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        // Encriptamos la contraseña antes de guardar
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Integer id, Usuario usuario) {

        Usuario usuarioA=usuarioRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("id no debe ser null" + id));
        if(Objects.equals(usuarioA.getPassword(), usuario.getPassword())){
            return usuarioRepository.save(usuario);
        }else{
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            return usuarioRepository.save(usuario);
        }


    }

    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findOneByUsername(username);
    }

    @Override
    public boolean cambiarPassword(Integer idUsuario, String passwordActual, String passwordNueva) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new ModelNotFoundException("Usuario no encontrado con id: " + idUsuario));

        // Verificar si la contraseña actual es correcta
        if (!passwordEncoder.matches(passwordActual, usuario.getPassword())) {
            return false;
        }

        // Actualizar la contraseña
        usuario.setPassword(passwordEncoder.encode(passwordNueva));
        usuarioRepository.save(usuario);

        return true;
    }

    @Transactional
    public void actualizarFoto(Integer idUsuario, String urlFoto) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

        usuario.setUrlFilefoto(urlFoto);
        usuarioRepository.save(usuario);
    }

}
