package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnteteFactFour {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @ManyToOne
    private Fournisseur fournisseur;
    @OneToOne
    @JoinColumn(name = "ligne_fact_four_id", referencedColumnName = "id")
    private LigneFactFour ligneFactFour;
}
