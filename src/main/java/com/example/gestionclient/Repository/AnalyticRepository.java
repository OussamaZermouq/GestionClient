package com.example.gestionclient.Repository;

import com.example.gestionclient.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnalyticRepository extends JpaRepository<Commande, Integer> {
    @Query("SELECT c.client.client_id, p.id_produit FROM Commande c JOIN c.produits p")
    List<Object> clientCommande();
}
