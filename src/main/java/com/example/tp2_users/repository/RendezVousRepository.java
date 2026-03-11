package com.example.tp2_users.repository;

import com.example.tp2_users.Entities.Patient;
import com.example.tp2_users.Entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
    List<RendezVous> findAllByPatientId(Long id);
}
