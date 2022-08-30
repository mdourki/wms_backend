package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String nom;
    private String adresse;
    private String numTel;
    private String email;
    @ManyToOne
    private CategorieClient categorie;
    @OneToMany(mappedBy = "client" , fetch = FetchType.LAZY)
    private List<EnteteCmdClt> enteteCmdCltList;
    @OneToMany(mappedBy = "client" , fetch = FetchType.LAZY)
    private List<EnteteLivClt> enteteLivCltList;
    @OneToMany(mappedBy = "client" , fetch = FetchType.LAZY)
    private List<EnteteFactClt> enteteFactCltList;

    public List<String> getInfo() {
        List<String> list = new ArrayList<>();
        list.add(Integer.toString(ID));
        list.add(nom);
        list.add(adresse);
        list.add(numTel);
        list.add(email);
        list.add(categorie.getNom());
        return list;
    }
}
