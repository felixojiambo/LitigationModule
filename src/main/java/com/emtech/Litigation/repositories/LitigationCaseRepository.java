package com.emtech.Litigation.repositories;

import com.emtech.Litigation.models.LitigationCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LitigationCaseRepository extends JpaRepository<LitigationCase, Long> {

}
