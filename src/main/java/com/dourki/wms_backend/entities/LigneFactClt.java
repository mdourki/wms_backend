package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class LigneFactClt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @OneToOne
    @JoinColumn(name = "entete_fact_clt_id", referencedColumnName = "id")
    private EnteteFactClt enteteFactClt;
    @OneToOne
    @JoinColumn(name = "palette_id", referencedColumnName = "id")
    private Palette palette;

    public List<String> getInfo() {
        int paletteQte = palette.getQuantity();
        float prdtPrixUnit = palette.getProduit().getPrixUnit();
        float totalPrix = paletteQte * prdtPrixUnit;

        List<String> list = new ArrayList<>();

        list.add(Integer.toString(palette.getLigneRecepFour().getEnteteRecepFour().getID()));
        list.add("Livraison "+palette.getNom());
        list.add(enteteFactClt.getClient().getNom());
        list.add(palette.getProduit().getCodePrdt());
        list.add(palette.getProduit().getNom());
        list.add(palette.getProduit().getCouleur().getCodeClr());
        list.add(palette.getProduit().getTaille().getCodeTaille());
        list.add(Integer.toString(paletteQte));
        list.add(Float.toString(prdtPrixUnit));
        list.add(Float.toString(totalPrix));
        list.add(enteteFactClt.getClient().getAdresse());
        list.add(enteteFactClt.getClient().getNumTel());
        list.add(enteteFactClt.getClient().getEmail());

        return list;
    }
}
