package ipd.renade.renadeapi.service.impl;

import ipd.renade.renadeapi.dto.OrganizacionPartidaDTO;
import ipd.renade.renadeapi.model.Partidaelectronica;
import ipd.renade.renadeapi.repository.IGenericRepo;
import ipd.renade.renadeapi.repository.IPartidaelectronicaRepository;
import ipd.renade.renadeapi.service.IPartidaelectronicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PartidaelectronicaServiceImpl extends CRUDImpl<Partidaelectronica,Integer> implements IPartidaelectronicaService {
    private final IPartidaelectronicaRepository partidaelectronicaRepository;

    @Override
    protected IGenericRepo<Partidaelectronica, Integer> getRepo() {
        return partidaelectronicaRepository;
    }

    @Override
    public String getUltimoOrden(String numPartida,String numInscripcion) {
        return partidaelectronicaRepository.findNumByNumPartida(numPartida,numInscripcion).orElse("00");
    }

    @Override
    public long totalPartidas() {
        return partidaelectronicaRepository.count();
    }

    @Override
    public List<OrganizacionPartidaDTO> findOrganizacionesConPartidas() {
        return partidaelectronicaRepository.findOrganizacionesConPartidas();
    }

    @Override
    public List<Partidaelectronica> findAllBySigla(String sigla,String codigo) {
        return partidaelectronicaRepository.findPartidasBySigla(sigla,codigo);
    }
}