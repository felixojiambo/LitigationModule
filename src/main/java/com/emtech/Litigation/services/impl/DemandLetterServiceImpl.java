package com.emtech.Litigation.services.impl;
import com.emtech.Litigation.models.DemandLetter;
import com.emtech.Litigation.repositories.DemandLetterRepository;
import com.emtech.Litigation.services.DemandLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandLetterServiceImpl implements DemandLetterService {

    private final DemandLetterRepository demandLetterRepository;

    @Autowired
    public DemandLetterServiceImpl(DemandLetterRepository demandLetterRepository) {
        this.demandLetterRepository = demandLetterRepository;
    }

    public List<DemandLetter> findAll() {
        return demandLetterRepository.findAll();
    }

    public DemandLetter save(DemandLetter demandLetter) {
        return demandLetterRepository.save(demandLetter);
    }

    // Method to generate a demand letter
    public String generateDemandLetter(DemandLetter demandLetter) {
        // Example of generating a simple text representation
        String letter = "Dear " + demandLetter.getClientName() + ",\n\n" +
                "This is to notify you of the outstanding amount due under your loan agreement.\n\n" +
                "Please make the payment by " + demandLetter.getPaymentDeadline() + ".\n\n" +
                "Thank you,\n" +
                "Your Bank";
        return letter;
    }

    // Method to view a demand letter by its ID
    public DemandLetter viewDemandLetter(Long id) {
        Optional<DemandLetter> optionalDemandLetter = demandLetterRepository.findById(id);
        if (optionalDemandLetter.isPresent()) {
            return optionalDemandLetter.get();
        } else {
            throw new IllegalArgumentException("Demand letter not found with id " + id);
        }
    }

    // Method to mark a demand letter as sent
    public DemandLetter markAsSent(Long id) {
        DemandLetter demandLetter = demandLetterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Demand letter not found with id " + id));
        demandLetter.setSent(true);
        return demandLetterRepository.save(demandLetter);
    }
}

//
//import com.emtech.Litigation.models.DemandLetter;
//import com.emtech.Litigation.models.LitigationCase;
//import com.emtech.Litigation.repositories.DemandLetterRepository;
//import com.emtech.Litigation.repositories.LitigationCaseRepository;
//import com.emtech.Litigation.services.DemandLetterService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DemandLetterServiceImpl implements DemandLetterService {
//
//    private final LitigationCaseRepository litigationCaseRepository;
//    private final DemandLetterRepository demandLetterRepository;
//
//    public DemandLetterServiceImpl(LitigationCaseRepository litigationCaseRepository, DemandLetterRepository demandLetterRepository) {
//        this.litigationCaseRepository = litigationCaseRepository;
//        this.demandLetterRepository = demandLetterRepository;
//    }
//
//    public void generateDemandLetter(String caseReferenceNumber) {
//        if (caseReferenceNumber == null || caseReferenceNumber.isEmpty()) {
//
//            return;
//        }
//
//        LitigationCase litigationCase = litigationCaseRepository.findByCaseReferenceNumber(caseReferenceNumber);
//        if (litigationCase == null) {
//
//            return;
//        }
//
//        DemandLetter demandLetter = new DemandLetter();
//        demandLetter.setFirstName(litigationCase.getFirstName());
//        demandLetter.setLastName(litigationCase.getLastName());
//        // we add more fields based on what we have in our litigation model
//
//        demandLetterRepository.save(demandLetter);
//
//    }
//
//}
