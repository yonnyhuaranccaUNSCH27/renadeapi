package ipd.renade.renadeapi.repository;

import ipd.renade.renadeapi.model.Menu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IMenuRepository extends IGenericRepo<Menu, Integer> {
    @Query(value = """
    select m.* from tbl_menurol mr
    inner join tbl_usuariorol ur on ur.id_rol = mr.id_rol
    inner join tbl_menu m on m.id_menu = mr.id_menu
    inner join tbl_usuario u on u.id_usuario = ur.id_usuario
    where u.username = :username
""", nativeQuery = true)
    List<Menu> getMenuByUsername(@Param("username") String username);
}
