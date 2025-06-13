package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.exception.ModelNotFoundException;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.ICRUD;

import java.util.List;


public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));
    }

    @Override
    public void delete(ID id) {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));
        getRepo().deleteById(id);
    }
}
