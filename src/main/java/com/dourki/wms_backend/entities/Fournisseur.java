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

    public List<String> getInfoFourPrdts() {
        List<String> list = new ArrayList<>();
        List<Produit> produits1 = new ArrayList<>();
        for (EnteteFactFour enteteFactFour:enteteFactFourList) {
            Produit produit = enteteFactFour.getLigneFactFour().getPalette().getProduit();
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

    public List<String> getQuantityInfo() {
        List<String> list = new ArrayList<>();
        int qte = 0;

        for (EnteteFactFour enteteFactFour:enteteFactFourList) {
            Palette palette = enteteFactFour.getLigneFactFour().getPalette();
            if(palette.getEmplacement() != null) {
                qte+=palette.getQuantity();
            }
        }

        list.add(nom);
        list.add(Integer.toString(qte));
        return list;
    }

    public String toString() {
        return "Adresse : "+adresse
                +"\nNuméro de téléphone : "+numTel
                +"\nEmail : "+email
                +"\nCatégorie : "+categorie.getNom();
    }
}
