package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnteteRecepFour {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @ManyToOne
    private Fournisseur fournisseur;
    @OneToOne
    @JoinColumn(name = "ligne_recep_four_id", referencedColumnName = "id")
    private LigneRecepFour ligneRecepFour;
}
