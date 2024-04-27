package com.example.gestionclient.Controller;

import com.example.gestionclient.Model.Client;
import com.example.gestionclient.Request.ClientRequest;
import com.example.gestionclient.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {
    @Autowired
    private ClientService clientService;
    @PostMapping("/addClient")
    public ResponseEntity<String> addClient(@RequestBody ClientRequest clientRequest){
        clientService.save(clientRequest);
        return ResponseEntity.accepted().build();
    }
    @GetMapping
    public ResponseEntity<List<Client>> findAllClient() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @DeleteMapping("/deleteClient")
    public ResponseEntity<String> deleteClient(@RequestBody ClientRequest clientRequest) throws Exception {
        clientService.remove(clientRequest);
        return ResponseEntity.ok("Client deleted");
    }
    @PutMapping("/modifyClient/{id}")
    public ResponseEntity<Client> modifyClient(
            @RequestBody ClientRequest clientRequest,
            @PathVariable Integer id)
            throws Exception {
        return clientService.modify(clientRequest, id);
    }
}
