package com.emtech.Litigation.models;

import com.emtech.Litigation.enums.CaseStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LitigationCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String caseReferenceNumber;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private  String middleName;
    @Column(nullable = false)
    private String clientEmail;
    @Column(nullable = false)
    private String clientPhoneNumber;
    @Column(nullable = false)
    private String loanId;
    @Column(nullable = false)
    private Double loanAmount;
    private String loanType;
    private String collateralDetails;
    private String insuranceCoverage;
    private String securityAttached;
    private String documentList;
    @Column(nullable = false)
    private Long cifId;
    private Date loanStartDate;
    private Date loanEndDate;
    @Column(nullable = false)
    private Long idNumber;
    @Column(nullable = false)
    private String kraPinNumber;
    private Long alternativePhoneNumber;
    private String postalAddress;
    private String postalCode;
    private String city;
    private String country;
    private String clientCode;
    private Long loanAccountNumber;
    private String interestRate;
    private Date defaultDate;
    private Double amountRemaining;
    private String loanDescription;
    private Date caseCreationDate;
    private String caseCreatedBy;
    private String caseNotes;
    @Enumerated(EnumType.STRING)
    private CaseStatus caseStatus;
    @PrePersist
    public void generateCaseReferenceNumber() {
        String loanTypePrefix = loanType.substring(0, Math.min(2, loanType.length())).toUpperCase();
        String cifIdDigits = String.format("%02d", cifId % 100);
        String loanAccountDigits = String.format("%02d", loanAccountNumber % 100);

        caseReferenceNumber = loanTypePrefix + cifIdDigits + loanAccountDigits;
    }
}
