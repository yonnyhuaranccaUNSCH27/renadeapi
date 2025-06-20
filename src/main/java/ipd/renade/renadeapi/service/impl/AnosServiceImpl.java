package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Anos;
import ipd.renade.renadeapi.repository.IAnosRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IAnosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnosServiceImpl extends CRUDImpl<Anos,Integer> implements IAnosService {

    private final IAnosRepository anosRepository;

    @Override
    protected IGenericRepo<Anos, Integer> getRepo() {
        return anosRepository;
    }
}
