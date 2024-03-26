package com.emtech.Litigation.controllers;

import com.emtech.Litigation.models.LitigationCase;
import com.emtech.Litigation.repositories.LitigationCaseRepository;
import com.emtech.Litigation.services.LitigationCaseInitiator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LitigationCaseInitiationController {

    private final LitigationCaseInitiator litigationCaseInitiator;

    public LitigationCaseInitiationController(LitigationCaseInitiator litigationCaseInitiator) {
        this.litigationCaseInitiator=litigationCaseInitiator;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> receiveCaseData(@RequestBody LitigationCase litigationCase) {
        litigationCaseInitiator.processCaseData(litigationCase);
        return new ResponseEntity<>("Case data received and processed successfully", HttpStatus.OK);
    }
    }

