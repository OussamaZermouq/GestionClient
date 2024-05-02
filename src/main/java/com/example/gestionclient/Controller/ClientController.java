package com.example.gestionclient.Controller;

import com.example.gestionclient.Model.Client;
import com.example.gestionclient.Request.ClientRequest;
import com.example.gestionclient.Service.ClientService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAllClient() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Integer id) throws Exception{
        Client client = clientService.findById(id).orElseThrow(()->new Exception("Client doesnt exists"));
        return ResponseEntity.ok(client);
    }
    @PostMapping("/addClient")
    public ResponseEntity<String> addClient(@RequestBody ClientRequest clientRequest){
        clientService.save(clientRequest);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/modifyClient/{id}")
    public ResponseEntity<Client> modifyClient(
            @RequestBody ClientRequest clientRequest,
            @PathVariable Integer id)
            throws Exception {
        return clientService.modify(clientRequest, id);
    }

    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Integer id) throws Exception {
        clientService.remove(id);
        return ResponseEntity.ok("Client deleted");
    }
}
