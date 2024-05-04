package com.example.gestionclient.Repository;

import com.example.gestionclient.Model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository  extends JpaRepository<Produit, Integer> {
}
