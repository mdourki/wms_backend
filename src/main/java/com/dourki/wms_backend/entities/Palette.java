package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Palette {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String nom;
    @Column(unique=true)
    private String numeroSerie;
    private int quantity;
    @ManyToOne
    private Produit produit;
    @OneToOne
    @JoinColumn(name = "emplacement_id", referencedColumnName = "id")
    private Emplacement emplacement;
    @OneToOne
    @JoinColumn(name = "ligne_cmd_four_id", referencedColumnName = "id")
    private LigneCmdFour ligneCmdFour;
    @OneToOne
    @JoinColumn(name = "ligne_recep_four_id", referencedColumnName = "id")
    private LigneRecepFour ligneRecepFour;
    @OneToOne
    @JoinColumn(name = "ligne_fact_four_id", referencedColumnName = "id")
    private LigneFactFour ligneFactFour;
    @OneToOne
    @JoinColumn(name = "ligne_cmd_clt_id", referencedColumnName = "id")
    private LigneCmdClt ligneCmdClt;
    @OneToOne
    @JoinColumn(name = "ligne_liv_clt_id", referencedColumnName = "id")
    private LigneLivClt ligneLivClt;
    @OneToOne
    @JoinColumn(name = "ligne_fact_clt_id", referencedColumnName = "id")
    private LigneFactClt ligneFactClt;

    public List<String> getInfo() {
        List<String> list = new ArrayList<>();
        list.add(Integer.toString(ID));
        list.add(nom);
        list.add(numeroSerie);
        list.add(produit.getCodePrdt());
        list.add(Integer.toString(quantity));
        return list;
    }
    public String toString(){
        return nom+" : "+numeroSerie;
    }

}
