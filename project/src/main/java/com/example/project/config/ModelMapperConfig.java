package com.example.project.config;

import com.example.project.dto.mapper.MappingRule;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ModelMapperConfig {

    List<MappingRule> mappingRules;

    public ModelMapperConfig(List<MappingRule> mappingRules) {
        this.mappingRules = mappingRules;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        configureEntityDtoMappings(modelMapper);

        return modelMapper;
    }

    private void configureEntityDtoMappings(ModelMapper modelMapper) {
        mappingRules.forEach(mappingRule -> mappingRule.addMappings(modelMapper));
    }
}
