package com.example.gestionclient.Service;

import com.example.gestionclient.Model.Commande;
import com.example.gestionclient.Repository.AnalyticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AnalyticService {
    private final AnalyticRepository analyticRepository;
    public List<Object> commandeParClient(){
        return analyticRepository.clientCommande();
    }

}
