package com.emtech.Litigation.services.impl;

import com.emtech.Litigation.models.DemandLetter;
import com.emtech.Litigation.models.LitigationCase;
import com.emtech.Litigation.repositories.DemandLetterRepository;
import com.emtech.Litigation.repositories.LitigationCaseRepository;
import com.emtech.Litigation.services.DemandLetterService;
import org.springframework.stereotype.Service;

@Service
public class DemandLetterServiceImpl implements DemandLetterService {

    private final LitigationCaseRepository litigationCaseRepository;
    private final DemandLetterRepository demandLetterRepository;

    public DemandLetterServiceImpl(LitigationCaseRepository litigationCaseRepository, DemandLetterRepository demandLetterRepository) {
        this.litigationCaseRepository = litigationCaseRepository;
        this.demandLetterRepository = demandLetterRepository;
    }

    public void generateDemandLetter(String caseReferenceNumber) {
        if (caseReferenceNumber == null || caseReferenceNumber.isEmpty()) {

            return;
        }

        LitigationCase litigationCase = litigationCaseRepository.findByCaseReferenceNumber(caseReferenceNumber);
        if (litigationCase == null) {

            return;
        }

        DemandLetter demandLetter = new DemandLetter();
        demandLetter.setFirstName(litigationCase.getFirstName());
        demandLetter.setLastName(litigationCase.getLastName());
        // we add more fields based on what we have in our litigation model

        demandLetterRepository.save(demandLetter);

    }

}
