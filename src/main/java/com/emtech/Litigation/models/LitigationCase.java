package com.emtech.Litigation.models;

import com.emtech.Litigation.enums.CaseStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LitigationCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String caseId;

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private String loanDetails;

    @Enumerated(EnumType.STRING)
    private CaseStatus caseStatus;
}
