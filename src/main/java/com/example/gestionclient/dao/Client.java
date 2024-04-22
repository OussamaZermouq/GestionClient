package com.example.gestionclient.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int client_id;
    private String client_nom;
    private String client_prenom;
    private Date date_naiss;
    private String email;
    private String password;
    private String telephone;
    private String adresse;

    @OneToMany(mappedBy = "client")
    private List<Commande> commande;

    @OneToMany(mappedBy = "client")
    private List<Plaint> plaints;
}
