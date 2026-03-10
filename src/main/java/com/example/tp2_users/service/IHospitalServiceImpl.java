package com.example.tp2_users.service;

import com.example.tp2_users.Entities.Consultation;
import com.example.tp2_users.Entities.Medecin;
import com.example.tp2_users.Entities.Patient;
import com.example.tp2_users.Entities.RendezVous;
import com.example.tp2_users.repository.ConsultationRepository;
import com.example.tp2_users.repository.MedecinRepository;
import com.example.tp2_users.repository.PatientRepository;
import com.example.tp2_users.repository.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class IHospitalServiceImpl implements IHospitalService {
    private PatientRepository patientrepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;


    //injection de dependance
    public IHospitalServiceImpl(PatientRepository patientrepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientrepository = patientrepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }


    @Override
    public Patient savePatient(Patient patient) {
        //on ajoute des regles etier
        return patientrepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saverendezvous(RendezVous rendezVous) {

        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
