package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.dto.ListapartidaelectronicaResDTO;
import ipd.renade.renadeapi.model.Listapartidaelectronica;
import java.util.List;
public interface IListapartidaelectronicaService extends ICRUD<Listapartidaelectronica,Integer> {

     List<ListapartidaelectronicaResDTO> findAllResumeByIDRes(Integer id);

     List<ListapartidaelectronicaResDTO> findAllByIdOrg(Integer id);
}
