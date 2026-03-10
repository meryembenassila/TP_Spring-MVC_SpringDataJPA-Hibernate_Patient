package com.example.tp2_users.repository;

import com.example.tp2_users.Entities.Medecin;
import com.example.tp2_users.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long>
{
    Medecin findByNom(String name);
}
