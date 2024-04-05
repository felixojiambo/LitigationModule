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
    private String refNumber; // Our Ref
    private Date date;         // Date
    private String clientName; // Recipient's Name
    private String clientAddress; // Recipient's Address (including street, building, city, postal code, country)
    private String subject;    // Subject of the letter (e.g., Termination of Service Contract)
    private String contractDetails; // Details of the contract (e.g., Contract number, location)
    private String terminationReason; // Reason for termination
    private Date contractStartDate; // Contract start date
    private Date contractEndDate;   // Contract end date
    private Date terminationNoticeDate; // Date of termination notice
    private String paymentAmount;   // Amount to be paid
    private String paymentDeadline; // Deadline for payment
    private String paymentInstructions; // Payment instructions (e.g., Bank details)
    private String lawyerName;     // Name of the lawyer or law firm
    private String lawyerAddress; // Address of the lawyer or law firm
    private String ccRecipient;    // Copy recipient (e.g., Client)
    private boolean sent;

}
