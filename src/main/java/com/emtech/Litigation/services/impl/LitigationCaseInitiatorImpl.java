package com.emtech.Litigation.services.impl;

import com.emtech.Litigation.dtos.LitigationCaseDTO;
import com.emtech.Litigation.models.LitigationCase;
import com.emtech.Litigation.repositories.LitigationCaseRepository;
import com.emtech.Litigation.services.LitigationCaseInitiator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LitigationCaseInitiatorImpl implements LitigationCaseInitiator {

    private final LitigationCaseRepository caseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public LitigationCaseInitiatorImpl(LitigationCaseRepository caseRepository, ModelMapper modelMapper) {
        this.caseRepository = caseRepository;
        this.modelMapper = modelMapper;
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

}
