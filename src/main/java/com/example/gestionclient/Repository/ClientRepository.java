package com.example.gestionclient.Repository;

import com.example.gestionclient.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    //we use this interface since it has the needed function pre declared

}
