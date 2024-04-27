package com.example.gestionclient.Service;

import com.example.gestionclient.Model.Client;
import com.example.gestionclient.Repository.ClientRepository;
import com.example.gestionclient.Request.ClientRequest;
import lombok.RequiredArgsConstructor;
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
}
