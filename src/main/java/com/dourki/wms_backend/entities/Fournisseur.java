package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Fournisseur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String nom;
    private String adresse;
    private String numTel;
    private String email;
    @ManyToOne
    private CategorieFournisseur categorie;
    @OneToMany(mappedBy = "fournisseur" , fetch = FetchType.LAZY)
    private List<EnteteCmdFour> enteteCmdFourList;
    @OneToMany(mappedBy = "fournisseur" , fetch = FetchType.LAZY)
    private List<EnteteRecepFour> enteteRecepFourList;
    @OneToMany(mappedBy = "fournisseur" , fetch = FetchType.LAZY)
    private List<EnteteFactFour> enteteFactFourList;

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

    public String toString() {
        return "Adresse : "+adresse
                +"\nNuméro de téléphone : "+numTel
                +"\nEmail : "+email
                +"\nCatégorie : "+categorie.getNom();
    }
}
