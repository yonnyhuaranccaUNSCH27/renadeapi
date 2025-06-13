package ipd.renade.renadeapi.service;

import ipd.renade.renadeapi.model.Ubigeo;
import java.util.List;
public interface IUbigeoService extends ICRUD<Ubigeo,Integer> {
    public List<Ubigeo> getAllCountries();
    public List<Ubigeo> getDepartments();

    public List<Ubigeo> getProviciasByDepartment(String department) ;

    public List<Ubigeo> getDistritos(String department,String provincia) ;
}
