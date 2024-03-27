package com.emtech.Litigation.controllers;
import com.emtech.Litigation.dtos.CourtCaseDTO;
import com.emtech.Litigation.services.CourtCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/court/")
public class CourtCaseController {
    private final CourtCaseService courtCaseService;

    public CourtCaseController(CourtCaseService courtCaseService) {
        this.courtCaseService = courtCaseService;
    }

    @PostMapping("/file-case")
    public ResponseEntity<String> fileCase(@RequestBody CourtCaseDTO courtCaseDTO) {
        courtCaseService.fileCase(courtCaseDTO);
        return new ResponseEntity<>("Case filed successfully", HttpStatus.CREATED);
    }
}
