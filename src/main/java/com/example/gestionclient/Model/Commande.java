package com.example.gestionclient.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commande_id;
    private String commande_titre;
    private LocalDate commande_date;
    private int quantitee;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @ManyToMany(mappedBy = "commandes")
    private List<Produit> produits;

    @OneToOne
    private Plaint plaint;
}
