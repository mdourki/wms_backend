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
public class EnteteLivClt {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @ManyToOne
    private Client client;
    @OneToOne
    @JoinColumn(name = "ligne_liv_clt_id", referencedColumnName = "id")
    private LigneLivClt ligneLivClt;
}
