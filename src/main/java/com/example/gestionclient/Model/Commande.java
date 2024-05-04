package com.example.gestionclient.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commande_id;
    private String commande_titre;
    private LocalDate commande_date;
    private int quantitee;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "PRODUIT_COMMANDE",
            joinColumns = @JoinColumn(name = "commande_id"),
            inverseJoinColumns = @JoinColumn(name = "id_produit")
    )
    private List<Produit> produits;

    @OneToOne
    private Plaint plaint;
}
