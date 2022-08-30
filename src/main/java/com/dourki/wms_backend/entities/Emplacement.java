package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Emplacement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String allee;
    private String nivHoriz;
    private String nivVerti;
    @ManyToOne
    private Depot depot;
    @OneToOne
    @JoinColumn(name = "palette_id", referencedColumnName = "id")
    private Palette palette;

    public List<String> getInfo() {
        List<String> list = new ArrayList<>();
        list.add(Integer.toString(ID));
        list.add(allee);
        list.add(nivHoriz);
        list.add(nivVerti);
        list.add(depot.getLibelle());
        return list;
    }
}
