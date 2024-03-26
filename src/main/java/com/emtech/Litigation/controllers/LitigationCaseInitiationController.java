package com.emtech.Litigation.controllers;

import com.emtech.Litigation.dtos.LitigationCaseDTO;
import com.emtech.Litigation.models.LitigationCase;
import com.emtech.Litigation.repositories.LitigationCaseRepository;
import com.emtech.Litigation.services.LitigationCaseInitiator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud/")
public class LitigationCaseInitiationController {

    private final LitigationCaseInitiator litigationCaseInitiator;

    public LitigationCaseInitiationController(LitigationCaseInitiator litigationCaseInitiator) {
        this.litigationCaseInitiator=litigationCaseInitiator;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> receiveCaseData(@RequestBody LitigationCaseDTO litigationCaseDTO) {
        litigationCaseInitiator.processCaseData(litigationCaseDTO);
        return new ResponseEntity<>("Case data received and processed successfully", HttpStatus.OK);
    }
    }

