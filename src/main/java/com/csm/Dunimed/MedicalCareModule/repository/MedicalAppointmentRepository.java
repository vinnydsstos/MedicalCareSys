package com.csm.Dunimed.MedicalCareModule.repository;

import com.csm.Dunimed.MedicalCareModule.model.MedicalAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Integer> {
}