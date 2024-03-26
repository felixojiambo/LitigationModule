package com.emtech.Litigation.services.impl;

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
        public void processCaseData(LitigationCase litigationCase) {
            // Add any validation or processing logic here if needed
            caseRepository.save(litigationCase);
        }
    }

