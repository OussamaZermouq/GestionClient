package com.example.gestionclient.Service;

import com.example.gestionclient.Model.Client;
import com.example.gestionclient.Repository.ClientRepository;
import com.example.gestionclient.Request.ClientRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    public void save(ClientRequest clientRequest){
        var client = Client.builder()
                .client_id(clientRequest.getClient_id())
                .client_nom(clientRequest.getClient_nom())
                .client_prenom(clientRequest.getClient_prenom())
                .date_naiss(clientRequest.getDate_naiss())
                .email(clientRequest.getEmail())
                .password(clientRequest.getPassword())
                .telephone(clientRequest.getTelephone())
                .adresse(clientRequest.getAdresse())
                .status(clientRequest.getStatus())
                .build();
        clientRepository.save(client);
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }


    public void remove(ClientRequest clientRequest) throws Exception {
        //Optional because its possible that the client doesnt exist
        Client client_remove = clientRepository.findById(clientRequest.getClient_id()).orElseThrow(()->new Exception("Client doesnt exist"));
        if (client_remove != null){
            clientRepository.delete(client_remove);
        }
    }

    public ResponseEntity<Client> modify(ClientRequest clientRequest, Integer id) throws Exception {
        Client client_mod = clientRepository.findById(id).orElseThrow(()-> new Exception("Client doesnt exist"));
        if (client_mod != null){
            client_mod.setClient_nom(clientRequest.getClient_nom());
            client_mod.setClient_prenom(clientRequest.getClient_prenom());
            client_mod.setDate_naiss(clientRequest.getDate_naiss());
            client_mod.setEmail(clientRequest.getEmail());
            client_mod.setPassword(clientRequest.getPassword());
            client_mod.setTelephone(clientRequest.getTelephone());
            client_mod.setAdresse(clientRequest.getAdresse());
            client_mod.setStatus(clientRequest.getStatus());
            client_mod.setCommande(clientRequest.getCommandeList());
            client_mod.setPlaints(clientRequest.getPlaintsList());
            Client nvClient = clientRepository.save(client_mod);
            return ResponseEntity.ok(nvClient);
        }
        return null;
    }
}
