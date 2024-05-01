package com.example.gestionclient.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_produit;
    private String titre_produit;
    private String type;
    private String couleur;
    private float prix;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category categorie;

    @ManyToMany
    @JoinTable(
            name = "PRODUIT_COMMANDE",
            joinColumns = @JoinColumn(name = "id_produit"),
            inverseJoinColumns = @JoinColumn(name = "commande_id")
    )
    private List<Commande> commandes;
}
