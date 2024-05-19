package com.example.gestionclient.Controller;


import com.example.gestionclient.Model.Commande;
import com.example.gestionclient.Service.AnalyticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/analytics")
public class AnalyticConroller {
    @Autowired
    private AnalyticService analyticService;

    @GetMapping("/commandeClient")
    public ResponseEntity<List<Object>> getCommandeClient(){
        return ResponseEntity.ok(analyticService.commandeParClient());
    }
}
