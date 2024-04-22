package com.example.gestionclient.Controller;

import com.example.gestionclient.Repository.ClientRepository;
import com.example.gestionclient.dao.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;


}
