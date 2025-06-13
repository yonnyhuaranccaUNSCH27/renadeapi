package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario,Integer> {
    Usuario findByUsername(String username);
    boolean cambiarPassword(Integer idUsuario, String passwordActual, String passwordNueva);
    void actualizarFoto(Integer idUsuario, String base64Foto);
}
