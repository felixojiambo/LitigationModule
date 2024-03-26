package com.emtech.Litigation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapper {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper;
        modelMapper = new ModelMapper();
        return modelMapper;
    }
}
