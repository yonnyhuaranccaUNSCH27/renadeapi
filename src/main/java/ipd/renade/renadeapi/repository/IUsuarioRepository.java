package ipd.renade.renadeapi.repository;

import ipd.renade.renadeapi.model.Usuario;

public interface IUsuarioRepository extends IGenericRepo<Usuario,Integer> {
    //DerivedQuery
    Usuario findOneByUsername(String username);

}
