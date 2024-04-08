package com.emtech.Litigation.services.impl;

import com.emtech.Litigation.dtos.LitigationCaseDTO;
import com.emtech.Litigation.models.LitigationCase;
import com.emtech.Litigation.repositories.LitigationCaseRepository;
import com.emtech.Litigation.services.LitigationCaseInitiator;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Service
public class LitigationCaseInitiatorImpl implements LitigationCaseInitiator {

    private final LitigationCaseRepository caseRepository;
    private final ModelMapper modelMapper;
    private final WebClient webClient;
    private final Validator validator;

    @Autowired
    public LitigationCaseInitiatorImpl(LitigationCaseRepository caseRepository, ModelMapper modelMapper) {
        this.caseRepository = caseRepository;
        this.modelMapper = modelMapper;
        this.webClient = WebClient.create("http://client-management-system.com/api");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = (Validator) factory.getValidator();
    }

    @Override
    public void processCaseData(LitigationCaseDTO litigationCaseDTO) {
        Errors errors = new BeanPropertyBindingResult(litigationCaseDTO, "litigationCaseDTO");
        validator.validate(litigationCaseDTO, errors);
        if (errors.hasErrors()) {
            throw new IllegalArgumentException(errors.getAllErrors().toString());
        }
        try {
            LitigationCase litigationCase = modelMapper.map(litigationCaseDTO, LitigationCase.class);
            caseRepository.save(litigationCase);
        } catch (Exception e) {
            throw new RuntimeException("Failed to process case data", e);
        }
    }

    public void fetchAndProcessCaseData(String caseId) {
        Mono<LitigationCaseDTO> caseDataMono = webClient.get()
                .uri("/cases/{caseId}", caseId)
                .retrieve()
                .bodyToMono(LitigationCaseDTO.class);

        caseDataMono.subscribe(litigationCaseDTO -> {
            try {
                processCaseData(litigationCaseDTO);
            } catch (Exception e) {
                System.err.println("Failed to process fetched case data: " + e.getMessage());
            }
        });
    }
}
