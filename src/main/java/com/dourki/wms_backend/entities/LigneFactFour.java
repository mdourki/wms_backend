package com.dourki.wms_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class LigneFactFour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @OneToOne
    @JoinColumn(name = "entete_fact_four_id", referencedColumnName = "id")
    private EnteteFactFour enteteFactFour;
    @OneToOne
    @JoinColumn(name = "palette_id", referencedColumnName = "id")
    private Palette palette;

    public List<String> getInfo() {
        int paletteQte = palette.getQuantity();
        float prdtPrixUnit = palette.getProduit().getPrixUnit();
        float totalPrix = paletteQte * prdtPrixUnit;

        List<String> list = new ArrayList<>();

        list.add(Integer.toString(palette.getLigneRecepFour().getEnteteRecepFour().getID()));
        list.add("Réception "+palette.getNom());
        list.add(enteteFactFour.getFournisseur().getNom());
        list.add(palette.getProduit().getCodePrdt());
        list.add(palette.getProduit().getNom());
        list.add(palette.getProduit().getCouleur().getCodeClr());
        list.add(palette.getProduit().getTaille().getCodeTaille());
        list.add(Integer.toString(paletteQte));
        list.add(Float.toString(prdtPrixUnit));
        list.add(Float.toString(totalPrix));
        list.add(enteteFactFour.getFournisseur().getAdresse());
        list.add(enteteFactFour.getFournisseur().getNumTel());
        list.add(enteteFactFour.getFournisseur().getEmail());

        return list;
    }
}
