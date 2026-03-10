package com.example.tp2_users.repository;

import com.example.tp2_users.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
  Patient findByNom(String name);
}
