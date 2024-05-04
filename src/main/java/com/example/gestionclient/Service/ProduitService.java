package com.example.gestionclient.Service;


import com.example.gestionclient.Model.Produit;
import com.example.gestionclient.Repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitService {
    private final ProduitRepository produitRepository;
    public void save (Produit produit){
        var prod = Produit.builder()
                .id_produit(produit.getId_produit()).titre_produit(produit.getTitre_produit())
                .type(produit.getType()).couleur(produit.getCouleur()).prix(produit.getPrix())
                .categorie(produit.getCategorie()).commandes(produit.getCommandes()).build();
        produitRepository.save(produit);
    }
    public List<Produit> findAll(){
        return produitRepository.findAll();
    }
    public void remove ( Integer id) throws Exception{
        Produit produit_remove = produitRepository.findById(id).orElseThrow(()->new Exception("produit doesent exist"));
        if (produit_remove != null ){
            produitRepository.delete(produit_remove);
        }

    }
    public ResponseEntity<Produit> modify (Produit produit , Integer id )throws Exception{
        Produit prod_modify=produitRepository.findById(id).orElseThrow(()->new Exception("produit dosent exist "));
        if (prod_modify!= null){
            prod_modify.setTitre_produit(produit.getTitre_produit());
            prod_modify.setType(produit.getType());
            prod_modify.setCouleur(produit.getCouleur());
            prod_modify.setPrix(produit.getPrix());
            prod_modify.setCategorie(produit.getCategorie());
            prod_modify.setCommandes(produit.getCommandes());
            Produit nvProduit = produitRepository.save(prod_modify);
            return ResponseEntity.ok(nvProduit);


        }
        return null;
    }

}
