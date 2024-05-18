package com.example.gestionclient.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToOne
    @JsonIgnoreProperties("produits")
    private Category categorie;

    @ManyToMany(mappedBy = "produits")
    @JsonIgnore
    private List<Commande> commandes;
}