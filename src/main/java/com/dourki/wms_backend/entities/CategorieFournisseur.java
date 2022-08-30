package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class CategorieFournisseur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String nom;
    @OneToMany(mappedBy = "categorie" , fetch = FetchType.LAZY)
    private List<Fournisseur> fournisseurs;
}
