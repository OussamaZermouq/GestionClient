package com.example.gestionclient.Controller;


import com.example.gestionclient.Model.Produit;
import com.example.gestionclient.Service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produit")
@RequiredArgsConstructor
public class ProduitController {
    @Autowired
    private ProduitService produitService;
    @PostMapping("/addProduit")
    public ResponseEntity<String> addProduit (@RequestBody Produit produit){
        produitService.save(produit);
        return  ResponseEntity.accepted().build();

    }
    @GetMapping
    public ResponseEntity<List<Produit>> findAllProduit(){

        return ResponseEntity.ok(produitService.findAll());
    }
    @DeleteMapping("/deleteProduit")
    public ResponseEntity<String> deleteProduit(@PathVariable Integer id)throws Exception{
        produitService.remove(id);
        return ResponseEntity.ok("produit deleted");
    }
    @PutMapping("/modifyProduit/{id}")
    public ResponseEntity<Produit> modiferProduit(
            @RequestBody Produit produit,
            @PathVariable Integer id) throws Exception{
        return produitService.modify(produit,id);
    }
}
