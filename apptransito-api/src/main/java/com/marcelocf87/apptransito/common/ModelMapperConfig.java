package com.marcelocf87.apptransito.common;

import com.marcelocf87.apptransito.api.model.VeiculoModel;
import com.marcelocf87.apptransito.domain.model.Veiculo;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Veiculo.class, VeiculoModel.class)
                .addMappings(mapper -> mapper.map(Veiculo::getPlaca, VeiculoModel::setPlaca));

        return modelMapper;

    }

}
