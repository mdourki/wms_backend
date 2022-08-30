package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class LigneLivClt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @OneToOne
    @JoinColumn(name = "entete_liv_clt_id", referencedColumnName = "id")
    private EnteteLivClt enteteLivClt;
    @OneToOne
    @JoinColumn(name = "palette_id", referencedColumnName = "id")
    private Palette palette;
}
