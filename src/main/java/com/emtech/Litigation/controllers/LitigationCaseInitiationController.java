package com.emtech.Litigation.controllers;

import com.emtech.Litigation.dtos.LitigationCaseDTO;
import com.emtech.Litigation.services.LitigationCaseInitiator;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.BindingResult;


@RestController
@RequestMapping("/crud/")
public class LitigationCaseInitiationController {

    private final LitigationCaseInitiator litigationCaseInitiator;

    public LitigationCaseInitiationController(LitigationCaseInitiator litigationCaseInitiator) {
        this.litigationCaseInitiator = litigationCaseInitiator;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> receiveCaseData(@Valid @RequestBody LitigationCaseDTO litigationCaseDTO, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
        }
        litigationCaseInitiator.processCaseData(litigationCaseDTO);
        return new ResponseEntity<>("Case data received and processed successfully", HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
