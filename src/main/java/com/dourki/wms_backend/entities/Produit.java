package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Produit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String codePrdt;
    private String nom;
    private String codeBarre;
    private String designation;
    private String libelleTicket;
    private float prixUnit;
    private float prixHT;
    private float prixTTC;
    @ManyToOne
    private Couleur couleur;
    @ManyToOne
    private Taille taille;
    @ManyToOne
    private Collection collection;
    @ManyToOne
    private Style style;
    @ManyToOne
    private Famille famille;
    @ManyToOne
    private TVA tva;
    @OneToMany(mappedBy = "produit" , fetch = FetchType.LAZY)
    private List<Palette> palettes;

    public List<String> getInfo() {
        List<String> list = new ArrayList<>();
        list.add(Integer.toString(ID));
        list.add(codePrdt);
        list.add(nom);
        list.add(codeBarre);
        list.add(designation);
        list.add(libelleTicket);
        list.add(String.format("%.2f",prixUnit));
        list.add(String.format("%.2f",prixHT));
        list.add(String.format("%.2f",prixTTC));
        list.add(couleur.getNom());
        list.add(taille.getNom());
        list.add(collection.getNom());
        list.add(style.getNom());
        list.add(famille.getNom());
        list.add(String.format("%.2f",tva.getTaux()));
        return list;
    }

    public String toString(){
        return "Nom : " + nom
                + "\nDesignation : " + designation
                + "\nCode du produit : " + codePrdt
                + "\nCode barre : " + codeBarre
                + "\nPrix unitaire : " + prixUnit
                + "\nPrix hors taxes : " + prixHT
                + "\nPrix TTC : " + prixTTC;
    }
}
