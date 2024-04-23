package com.example.gestionclient.Controller;

import com.example.gestionclient.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/Client")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;


    @GetMapping
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Hello from secured endpoint");
    }

}
