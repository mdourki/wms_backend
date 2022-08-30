package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class LigneCmdClt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @OneToOne
    @JoinColumn(name = "entete_cmd_clt_id", referencedColumnName = "id")
    private EnteteCmdClt enteteCmdClt;
    @OneToOne
    @JoinColumn(name = "palette_id", referencedColumnName = "id")
    private Palette palette;
}
