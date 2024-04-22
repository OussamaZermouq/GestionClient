package com.example.gestionclient.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plaint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int plaint_id;
    private String plaint_titre;
    private String plaint_description;
    private Date plaint_date;
    private String plaint_status;

    @ManyToOne
    private Client client;

    @OneToOne
    private Commande commande;

}
