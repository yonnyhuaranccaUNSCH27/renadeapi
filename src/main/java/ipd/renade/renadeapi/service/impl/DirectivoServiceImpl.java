package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.model.Directivo;
import ipd.renade.renadeapi.repository.IDirectivoRepository;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.service.IDirectivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DirectivoServiceImpl extends CRUDImpl<Directivo,Integer> implements IDirectivoService {

    private final IDirectivoRepository directivoRepository;

    @Override
    protected IGenericRepo<Directivo, Integer> getRepo() {
        return directivoRepository;
    }
}
