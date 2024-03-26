package com.emtech.Litigation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    public class DemandLetter {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String firstName;
        private String lastName;
        private String clientEmail;
        private String clientPhoneNumber;
        private Double loanAmount;
        private String loanType;
        private String collateralDetails;
        private String insuranceCoverage;
        private String securityAttached;
        private Long cifId;
        private Date loanStartDate;
        private Date loanEndDate;
        private Long idNumber;
        private String kraPinNumber;
        private String postalAddress;
        private String postalCode;
        private String city;
        private String country;
        private Long loanAccountNumber;
        private String interestRate;
        private Date defaultDate;
        private Double amountRemaining;
        private String loanDescription;
        private Date caseCreationDate;
        private String caseCreatedBy;

    }

