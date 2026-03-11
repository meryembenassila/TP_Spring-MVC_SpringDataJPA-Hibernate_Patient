package com.example.tp2_users.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity //pour les getters et les setters
public class Patient {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String nom;
     @Temporal(TemporalType.DATE)
     private Date dateNaissance;
     private boolean malade;
     @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
     @ToString.Exclude
     private Collection<RendezVous> rendezVous;

}
