package com.emtech.Litigation.services.impl;

import com.emtech.Litigation.dtos.LitigationCaseDTO;
import com.emtech.Litigation.models.LitigationCase;
import com.emtech.Litigation.repositories.LitigationCaseRepository;
import com.emtech.Litigation.services.LitigationCaseInitiator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class LitigationCaseInitiatorImpl implements LitigationCaseInitiator {

    private final LitigationCaseRepository caseRepository;
    private final ModelMapper modelMapper;
    private final WebClient webClient;

    @Autowired
    public LitigationCaseInitiatorImpl(LitigationCaseRepository caseRepository, ModelMapper modelMapper) {
        this.caseRepository = caseRepository;
        this.modelMapper = modelMapper;
        this.webClient = WebClient.create("http://client-management-system.com/api");
    }

    @Override
    public void processCaseData(LitigationCaseDTO litigationCaseDTO) {
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
                // Handle exception
                System.err.println("Failed to process fetched case data: " + e.getMessage());
            }
        });
    }
}
