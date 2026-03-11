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
@Entity
public class Medecin {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private  String nom;
  private String email;
  private String spetialite;
  @OneToMany(mappedBy = "medecin" ,fetch= FetchType.LAZY)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @ToString.Exclude
  private Collection<RendezVous> rendezVous;
}
