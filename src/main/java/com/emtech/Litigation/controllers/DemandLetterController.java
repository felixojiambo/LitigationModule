package com.emtech.Litigation.controllers;
import com.emtech.Litigation.services.DemandLetterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demand/")
public class DemandLetterController {
    private final DemandLetterService demandLetterService;

    public DemandLetterController(DemandLetterService demandLetterService) {
        this.demandLetterService = demandLetterService;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateDemandLetter(@RequestBody String caseReferenceNumber) {
        demandLetterService.generateDemandLetter(caseReferenceNumber);
        return new ResponseEntity<>("Demand letter generated successfully", HttpStatus.OK);
    }
    }
