package com.example.gestionclient.Controller;

import com.example.gestionclient.Model.Commande;
import com.example.gestionclient.Service.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/commande")
@RequiredArgsConstructor
public class CommandeController {

    @Autowired
    private CommandeService commandeService ;
   @PostMapping("/addCommande")
    public ResponseEntity<String> addCommande (@RequestBody Commande commande){
       System.out.println(commande);
       commandeService.save(commande);
       return  ResponseEntity.accepted().build();
   }
   @GetMapping
    public ResponseEntity<List<Commande>> findAllCommande(){
       return ResponseEntity.ok(commandeService.findAll());
   }


   @DeleteMapping("/deleteComande/{id}")
    public ResponseEntity<String> deleteCommande(@PathVariable Integer id)throws Exception{
       try{
           commandeService.remove(id);
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return ResponseEntity.ok("Commande deleted");
   }


    @PutMapping("/modifyCommande/{id}")
    public ResponseEntity<Commande> modiferCommande(
            @RequestBody Commande commade,
            @PathVariable Integer id) throws Exception{
        return commandeService.modify(commade,id);
    }


}
