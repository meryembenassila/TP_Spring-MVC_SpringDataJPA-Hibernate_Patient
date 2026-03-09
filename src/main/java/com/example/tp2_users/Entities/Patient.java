package com.example.tp2_users.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data //pour les getters et les setters
public class Patient {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String nom;
     @Temporal(TemporalType.DATE)
     private Date dateNaissance;
     private boolean malade;
     @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
     private Collection<RendezVous> rendezVous;

}
