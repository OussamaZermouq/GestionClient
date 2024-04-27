package com.example.gestionclient.Controller;

import com.example.gestionclient.Model.Client;
import com.example.gestionclient.Repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ClientController {
    private ClientRepository clientRepository;

    @PostMapping("/addClient")
    public ResponseEntity<String> addClient(@RequestBody Client client){
        clientRepository.save(client);
        return ResponseEntity.ok("Client added successfully");
    }

}
