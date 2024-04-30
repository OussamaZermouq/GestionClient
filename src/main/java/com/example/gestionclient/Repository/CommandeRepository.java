package com.example.gestionclient.Repository;

import com.example.gestionclient.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}
