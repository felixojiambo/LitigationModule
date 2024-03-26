package com.emtech.Litigation.services.impl;

import com.emtech.Litigation.dtos.LitigationCaseDTO;
import com.emtech.Litigation.models.LitigationCase;
import com.emtech.Litigation.repositories.LitigationCaseRepository;
import com.emtech.Litigation.services.LitigationCaseInitiator;
import org.springframework.stereotype.Service;

@Service
public class LitigationCaseInitiatorImpl implements LitigationCaseInitiator {


        private final LitigationCaseRepository caseRepository;

        public LitigationCaseInitiatorImpl(LitigationCaseRepository caseRepository) {
            this.caseRepository = caseRepository;
        }
    public void processCaseData(LitigationCaseDTO litigationCaseDTO) {
        // Convert DTO to entity
        LitigationCase litigationCase = convertDTOToEntity(litigationCaseDTO);
        // Add any validation or processing logic here if needed
        caseRepository.save(litigationCase);
    }
    private LitigationCase convertDTOToEntity(LitigationCaseDTO litigationCaseDTO) {
        LitigationCase litigationCase = new LitigationCase();
        // Copy fields from DTO to entity
        // For example:
        litigationCase.setId(litigationCaseDTO.getId());
        litigationCase.setCaseReferenceNumber(litigationCaseDTO.getCaseReferenceNumber());
        // Continue for all fields
        return litigationCase;
    }

}

