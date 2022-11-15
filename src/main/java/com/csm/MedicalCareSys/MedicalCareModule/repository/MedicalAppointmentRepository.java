package com.csm.MedicalCareSys.MedicalCareModule.repository;

import com.csm.MedicalCareSys.MedicalCareModule.model.MedicalAppointment;
import com.csm.MedicalCareSys.MedicalCareModule.model.MedicalAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Integer> {
}