package com.emtech.Litigation.services.impl;
import com.emtech.Litigation.dtos.CourtCaseDTO;
import com.emtech.Litigation.models.CourtCase;
import com.emtech.Litigation.models.Party;
import com.emtech.Litigation.repositories.CourtCaseRepository;
import com.emtech.Litigation.services.CourtCaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourtCaseServiceImpl implements CourtCaseService {
    private final CourtCaseRepository courtCaseRepository;

    public CourtCaseServiceImpl(CourtCaseRepository courtCaseRepository) {
        this.courtCaseRepository = courtCaseRepository;
    }

    @Override
    public void fileCase(CourtCaseDTO courtCaseDTO) {
        CourtCase courtCase = new CourtCase();
        courtCase.setCaseReferenceNumber(courtCaseDTO.getCaseReferenceNumber());

        List<Party> parties = courtCaseDTO.getParties().stream()
                .map(partyDTO -> {
                    Party party = new Party();
                    party.setName(partyDTO.getName());

                    party.setCourtCase(courtCase);
                    return party;
                })
                .collect(Collectors.toList());

        courtCase.setParties(parties);

        courtCaseRepository.save(courtCase);
    }
}
