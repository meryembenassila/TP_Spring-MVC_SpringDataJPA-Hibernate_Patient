package com.example.tp2_users.web;

import com.example.tp2_users.Entities.Patient;
import com.example.tp2_users.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//@RestController
@Controller

public class PatientConroller  {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public  String patients(Model model){
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients",patients);
        return "patients";
    }

}
