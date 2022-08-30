package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Depot {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String libelle;
    private String adresse;

    @OneToMany(mappedBy = "depot" , fetch = FetchType.LAZY)
    private List<Emplacement> emplacements;

    public List<String> getInfo() {
        List<String> list = new ArrayList<>();
        list.add(Integer.toString(ID));
        list.add(libelle);
        list.add(adresse);
        return list;
    }
}
