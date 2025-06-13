package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Listadisciplina;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IListadisciplinaRepository;
import ipd.renade.renadeapi.service.IListadisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListadisciplinaServiceImpl extends CRUDImpl<Listadisciplina,Integer> implements IListadisciplinaService {
    public final IListadisciplinaRepository listadisciplinaRepository;

    @Override
    protected IGenericRepo<Listadisciplina, Integer> getRepo() {
        return listadisciplinaRepository;
    }

    @Override
    public List<Listadisciplina> findAllByIdOrg(Integer id) {
        return listadisciplinaRepository.findAllByOrganizacion_IdOrganizacionDesc(id);
    }
}