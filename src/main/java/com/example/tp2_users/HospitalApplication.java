package com.example.tp2_users;

import com.example.tp2_users.Entities.*;
import com.example.tp2_users.repository.ConsultationRepository;
import com.example.tp2_users.repository.MedecinRepository;
import com.example.tp2_users.repository.PatientRepository;
import com.example.tp2_users.repository.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository) {
        return args -> {

            Stream.of("Mohamed", "Hassan", "Najat")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        patientRepository.save(patient);
                    });

            Stream.of("Hanane", "Aymane", "Yasmine")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpetialite(Math.random() > 0.5 ? "Cardio" : "Dentiste");
                        medecinRepository.save(medecin);
                    });

            Patient patient = patientRepository.findById(1L).orElse(null);//chercher le Patient dont l'id = 1 //Le L signifie que 1 est de type Long.//cette methode existe déjà dans Spring Data JPA.
            Patient patient1 = patientRepository.findByNom("Mohamed");

            Medecin medecin = medecinRepository.findByNom("Yasmine");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVousRepository.save(rendezVous);

            RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);

            Consultation consultation =new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("rapport de consultation ..");

            consultationRepository.save(consultation);


        };











        
    }


}
