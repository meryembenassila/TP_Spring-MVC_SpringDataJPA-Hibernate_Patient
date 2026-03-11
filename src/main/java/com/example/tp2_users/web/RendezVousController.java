package com.example.tp2_users.web;

import com.example.tp2_users.Entities.RendezVous;
import com.example.tp2_users.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class RendezVousController {
    @Autowired
    RendezVousRepository rendezVousRepository;

    @GetMapping("/rendezvous/{id}")
    public String getRendezVous(@PathVariable Long id, Model model){
        System.out.println("ID envoyé : " + id);
        List<RendezVous> rendezVous = rendezVousRepository.findAllByPatientId(id);
        System.out.println(rendezVous);
        //List<RendezVous> rendezVous= rendezVousRepository.findAllByPatientId(id);
        //System.out.println(rendezVousRepository.findAll().get(0));
        System.out.println(rendezVous);
        model.addAttribute("rendezVous",rendezVous);
        return "rendezvous";
    }
}
