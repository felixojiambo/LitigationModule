package com.emtech.Litigation.dtos;
import com.emtech.Litigation.enums.CaseStatus;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class LitigationCaseDTO {
        private Long id;
        private String caseReferenceNumber;
        private String firstName;
        private String lastName;
        private String middleName;
        private String clientEmail;
        private String clientPhoneNumber;
        private String loanId;
        private Double loanAmount;
        private String loanType;
        private String collateralDetails;
        private String insuranceCoverage;
        private String securityAttached;
        private String documentList;
        private Long cifId;
        private Date loanStartDate;
        private Date loanEndDate;
        private Long idNumber;
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
        private CaseStatus caseStatus;
    }

