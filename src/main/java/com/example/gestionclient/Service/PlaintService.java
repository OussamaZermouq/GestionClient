package com.example.gestionclient.Service;

import com.example.gestionclient.Model.Plaint;
import com.example.gestionclient.Repository.PlaintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class PlaintService {
    private final PlaintRepository plaintRepository;
    public void save (Plaint plaint){
        var pl =Plaint.builder().plaint_id(plaint.getPlaint_id())
                .plaint_titre(plaint.getPlaint_titre()).plaint_description(plaint.getPlaint_description())
                .plaint_date(plaint.getPlaint_date()).plaint_status(plaint.getPlaint_status()).client(plaint.getClient())
                .commande(plaint.getCommande()).build();
        plaintRepository.save(plaint);
    }


    public void remove(Integer id) throws Exception{
        Plaint plaintRemoved = plaintRepository.findById(id).orElseThrow(()->new Exception("Plaint dosent exist"));
    }
    public List<Plaint>findAll() { return plaintRepository.findAll();}

    public ResponseEntity<Plaint> modify (Plaint plaint ,Integer id )throws  Exception{
        Plaint plaintModify = plaintRepository.findById(id).orElseThrow(()->new Exception("Plaint dosent exist"));
        if (plaintModify!= null){
            plaintModify.setPlaint_titre(plaint.getPlaint_titre());
            plaintModify.setPlaint_description(plaint.getPlaint_description());
            plaintModify.setPlaint_date(plaint.getPlaint_date());
            plaintModify.setPlaint_status(plaint.getPlaint_status());
            plaintModify.setClient(plaint.getClient());
            plaintModify.setCommande(plaint.getCommande());
            Plaint nvPlaint = plaintRepository.save(plaintModify);
            return ResponseEntity.ok(nvPlaint);
        }
        return null;
    }



}
