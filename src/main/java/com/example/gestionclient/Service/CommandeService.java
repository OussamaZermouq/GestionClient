package com.example.gestionclient.Service;

import com.example.gestionclient.Model.Commande;
import com.example.gestionclient.Repository.CommandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandeService {
    private final CommandeRepository commandeRepository;
    public void save(Commande commande){
        var va = Commande. builder().commande_id(commande.getCommande_id())
                .commande_titre(commande.getCommande_titre())
                .commande_date(commande.getCommande_date()).quantitee(commande.getQuantitee())
                .status(commande.getStatus()).client(commande.getClient()).produits(commande.getProduits())
                .plaint(commande.getPlaint()).build();
        commandeRepository.save(commande);
    }
    public List <Commande> findAll(){ return  commandeRepository.findAll();}
     public void remove (Integer id )throws  Exception{
        Commande commande_remove = commandeRepository.findById(id).orElseThrow(()->new Exception("Commande dosent exist "));
        if ( commande_remove != null ){
            commandeRepository.delete(commande_remove);
        }
     }
     public ResponseEntity<Commande> modify (Commande commande, Integer id )throws Exception{
        Commande commande_mod = commandeRepository.findById(id).orElseThrow(()-> new Exception("commande dosenot exist"));
        if (commande_mod!= null){
            commande_mod.setCommande_titre(commande.getCommande_titre());
            commande_mod.setCommande_date(commande.getCommande_date());
            commande_mod.setQuantitee(commande.getQuantitee());
            commande_mod.setStatus(commande.getStatus());
            commande_mod.setClient(commande.getClient());
            commande_mod.setProduits(commande.getProduits());
            commande_mod.setPlaint(commande.getPlaint());
            Commande nvCommade = commandeRepository.save(commande_mod);
            return ResponseEntity.ok(nvCommade);

        }
        return null;
     }
}
