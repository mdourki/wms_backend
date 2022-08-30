package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Taille {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String codeTaille;
    private String nom;
    @OneToMany(mappedBy = "taille" , fetch = FetchType.LAZY)
    private List<Produit> produits;

    public List<String> getInfo() {
        List<String> list = new ArrayList<>();
        list.add(Integer.toString(ID));
        list.add(codeTaille);
        list.add(nom);
        return list;
    }
}
