package com.example.project.dto.mapper;

import org.modelmapper.ModelMapper;

public interface MappingRule {

    default void addMappings(ModelMapper modelMapper) {
        entityToDtoMapping(modelMapper);
        dtoToEntityMapping(modelMapper);
    }

    void entityToDtoMapping(ModelMapper modelMapper);

    void dtoToEntityMapping(ModelMapper modelMapper);
}
