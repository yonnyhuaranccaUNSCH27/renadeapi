package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Niveleducacion;
import ipd.renade.renadeapi.repository.INiveleducacionRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.INiveleducacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NiveleducacionServiceImpl extends CRUDImpl<Niveleducacion,Integer> implements INiveleducacionService {

    private final INiveleducacionRepository niveleducacionRepository;

    @Override
    protected IGenericRepo<Niveleducacion, Integer> getRepo() {
        return niveleducacionRepository;
    }
}
