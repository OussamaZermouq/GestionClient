package com.example.gestionclient.Controller;

import com.example.gestionclient.Model.Category;
import com.example.gestionclient.Model.Plaint;
import com.example.gestionclient.Repository.PlaintRepository;
import com.example.gestionclient.Service.PlaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/plaint")
@RequiredArgsConstructor
public class PlaintController {
    @Autowired
    private PlaintService plaintService;
    @PostMapping("/addplaint")
    public ResponseEntity<String> addPlaint(@RequestBody Plaint plaint){
        plaintService.save(plaint);
        return ResponseEntity.accepted().build();
    }
    @GetMapping
    public ResponseEntity<List<Plaint>> findAllPlaint ()
    {return ResponseEntity.ok(plaintService.findAll());}
    @DeleteMapping("/deletePlaint/{id}")
    public ResponseEntity<String > deleteplaine(@PathVariable Integer id )throws Exception{
        plaintService.remove(id);
        return ResponseEntity.ok("plaint deleted");

    }
    @PutMapping("/modifyPlaint/{id}")
    public ResponseEntity<Plaint> modiferPlaint(
            @RequestBody Plaint plaint,
            @PathVariable Integer id) throws Exception{
        return plaintService.modify(plaint,id);
    }
}
