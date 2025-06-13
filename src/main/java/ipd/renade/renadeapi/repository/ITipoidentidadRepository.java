package ipd.renade.renadeapi.repository;

import ipd.renade.renadeapi.model.Tipoidentidad;

public interface ITipoidentidadRepository extends IGenericRepo<Tipoidentidad,Integer> {
    /*
    @Query("UPDATE Tb_tipoidentidad a SET a.codigo=a.codigo WHERE a.id=?6")
    @Modifying
    void updateCodigo(String codigo,Integer id);
     */
}
