package com.example.tp2_users.service;

import com.example.tp2_users.Entities.Consultation;
import com.example.tp2_users.Entities.Medecin;
import com.example.tp2_users.Entities.Patient;
import com.example.tp2_users.Entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saverendezvous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
