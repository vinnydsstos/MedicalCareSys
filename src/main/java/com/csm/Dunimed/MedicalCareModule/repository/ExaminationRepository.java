package com.csm.Dunimed.MedicalCareModule.repository;

import com.csm.Dunimed.MedicalCareModule.model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Integer> {
}