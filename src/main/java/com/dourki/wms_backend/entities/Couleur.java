package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Couleur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String codeClr;
    private String nom;

    @OneToMany(mappedBy = "couleur" , fetch = FetchType.LAZY)
    private List<Produit> produits;

    public List<String> getInfo() {
        List<String> list = new ArrayList<>();
        list.add(Integer.toString(ID));
        list.add(codeClr);
        list.add(nom);
        return list;
    }
}
