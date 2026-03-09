package com.example.tp2_users.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Medecin {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private  String nom;
  private String email;
  private String spetialite;
  @OneToMany(mappedBy = "medecin" ,fetch= FetchType.LAZY)
  private Collection<RendezVous> rendezVous;
}
