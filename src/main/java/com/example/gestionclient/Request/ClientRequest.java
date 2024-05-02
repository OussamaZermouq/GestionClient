package com.example.gestionclient.Request;

import com.example.gestionclient.Model.Commande;
import com.example.gestionclient.Model.Plaint;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Builder
public class ClientRequest {
    private int client_id;
    private String client_nom;
    private String client_prenom;
    private Date date_naiss;
    private String email;
    private String telephone;
    private String adresse;
    private String status;
    private List<Commande> commandeList;
    private List<Plaint> plaintsList;
}
