package com.example.gestionclient.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Plaint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int plaint_id;
    private String plaint_titre;
    private String plaint_description;
    private LocalDate plaint_date;
    private String plaint_status;

    @ManyToOne
    private Client client;

    @OneToOne
    private Commande commande;

}
