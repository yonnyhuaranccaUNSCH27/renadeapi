package ipd.renade.renadeapi.config;

import ipd.renade.renadeapi.dto.DenominacionDTO;
import ipd.renade.renadeapi.model.Denominacion;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean(name = "defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

    /**@Bean(name = "DenominacionMapper")
    public ModelMapper DenominacionMapper() {
        ModelMapper modelMapper = new ModelMapper();

        //escritura
        //modelMapper.createTypeMap(DenominacionDTO.class, Denominacion.class)
        //        .addMapping(DenominacionDTO::getDescripcion,(dest,v)->dest.setDescripcion((String) v));

        //lectura
        //modelMapper.createTypeMap(Denominacion.class, DenominacionDTO.class)
        //        .addMapping(Denominacion::getDescripcion,(dest,v)->dest.setDescripcion((String) v));

        // Escritura (DTO -> Entidad)
        modelMapper.createTypeMap(DenominacionDTO.class, Denominacion.class)
                .addMappings(mapper -> mapper.map(DenominacionDTO::getDescripcion, Denominacion::setDescripcion));

        // Lectura (Entidad -> DTO)
        modelMapper.createTypeMap(Denominacion.class, DenominacionDTO.class)
                .addMappings(mapper -> mapper.map(Denominacion::getDescripcion, DenominacionDTO::setDescripcion));


        return modelMapper;
    }**/
}
