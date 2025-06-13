package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Ubigeo;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IUbigeoRepository;
import ipd.renade.renadeapi.service.IUbigeoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UbigeoServiceImpl extends CRUDImpl<Ubigeo,Integer> implements IUbigeoService {
    private final IUbigeoRepository ubigeoRepository;

    @Override
    protected IGenericRepo<Ubigeo, Integer> getRepo() {
        return ubigeoRepository;
    }

    @Override
    public List<Ubigeo> getAllCountries() {
        return ubigeoRepository.findAllCountries();
    }

    @Override
    public List<Ubigeo> getDepartments() {
        return ubigeoRepository.findAllDepartments();
    }

    @Override
    public List<Ubigeo> getProviciasByDepartment(String department) {
        return ubigeoRepository.findAllProviciaByDepartment(department);
    }

    @Override
    public List<Ubigeo> getDistritos(String department, String provincia) {
        return ubigeoRepository.findAllDitritos(provincia,department);
    }
}
