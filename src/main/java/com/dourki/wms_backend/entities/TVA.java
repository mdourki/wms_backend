package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class TVA {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private float taux;

    @OneToMany(mappedBy = "tva" , fetch = FetchType.LAZY)
    private List<Produit> produits;
}
