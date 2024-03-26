package com.emtech.Litigation.services;

import com.emtech.Litigation.dtos.LitigationCaseDTO;

;

public interface LitigationCaseInitiator {
    void processCaseData(LitigationCaseDTO litigationCaseDTO);
}
