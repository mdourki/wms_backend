package com.dourki.wms_backend.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Famille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String nom;

    @OneToMany(mappedBy = "famille" , fetch = FetchType.LAZY)
    private List<Produit> produits;

    public List<String> infoFamillePrdts(){
        List<String> list = new ArrayList<>();
        String prdts="";
        if(!produits.isEmpty()) {
            int i=0;
            for (i=0 ; i<produits.size()-1 ; i++){
                prdts+=produits.get(i).getCodePrdt()+" , ";
            }
            prdts+=produits.get(i).getCodePrdt();
        }
        else {
            prdts = "Aucun produit";
        }
        list.add(nom);
        list.add(prdts);
        return list;
    }
}
