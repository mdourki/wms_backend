package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
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

    public List<String> getInfoCltPrdts() {
        List<String> list = new ArrayList<>();
        List<Produit> produits1 = new ArrayList<>();
        for (EnteteFactClt enteteFactClt:enteteFactCltList) {
            Produit produit = enteteFactClt.getLigneFactClt().getPalette().getProduit();
            produits1.add(produit);
        }

        List<Produit> produits = new ArrayList<>(new HashSet<>(produits1));

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
