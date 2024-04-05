package com.emtech.Litigation.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Documents {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private String contentType;
        @Lob
        private byte[] content;

    public void setCourtCase(CourtCase courtCase) {
    }
}

