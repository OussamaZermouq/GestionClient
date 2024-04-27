package com.example.gestionclient.Request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;



@Getter
@Setter
@Builder
public class ClientRequest {
    private int client_id;
    private String client_nom;
    private String client_prenom;
    private Date date_naiss;
    private String email;
    private String password;
    private String telephone;
    private String adresse;
    private String status;
}
