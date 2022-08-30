package com.dourki.wms_backend.Web;

import com.dourki.wms_backend.Services.*;
import com.dourki.wms_backend.entities.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class MouvementFourRestAPI {

    PaletteService paletteService;
    FournisseurService fournisseurService;
    EnteteCmdFourService enteteCmdFourService;
    LigneCmdFourService ligneCmdFourService;
    EmplacementService emplacementService;
    EnteteRecepFourService enteteRecepFourService;
    LigneRecepFourService ligneRecepFourService;
    EnteteFactFourService enteteFactFourService;
    LigneFactFourService ligneFactFourService;

    @PostMapping("/cmdFour/save/{paletteID}/{fournisseurID}")
    public String postCmdFour(@PathVariable int paletteID , @PathVariable int fournisseurID) {
        Palette palette = paletteService.getPaletteByID(paletteID);
        Fournisseur fournisseur = fournisseurService.getFournisseurByID(fournisseurID);

        if(palette.getLigneCmdFour()!=null && palette.getLigneCmdFour().getEnteteCmdFour().getFournisseur().getID() == fournisseurID) {
            return "Cette palette est déjà enregistrée dans une commande";
        }

        EnteteCmdFour enteteCmdFour = new EnteteCmdFour();
        LigneCmdFour ligneCmdFour = new LigneCmdFour();

        enteteCmdFour.setFournisseur(fournisseur);
        enteteCmdFourService.saveEnteteCmd(enteteCmdFour);

        ligneCmdFour.setEnteteCmdFour(enteteCmdFour);
        ligneCmdFour.setPalette(palette);
        ligneCmdFourService.saveLigneCmd(ligneCmdFour);

        enteteCmdFour.setLigneCmdFour(ligneCmdFour);
        enteteCmdFourService.saveEnteteCmd(enteteCmdFour);

        ligneCmdFour.setEnteteCmdFour(enteteCmdFour);
        ligneCmdFourService.saveLigneCmd(ligneCmdFour);

        palette.setLigneCmdFour(ligneCmdFour);
        paletteService.savePalette(palette);

        return "Commande bien enregistrée";
    }

    @GetMapping("/listPalettesToCmd")
    public List<List<String>> getListPalettesToCmd() {
        List<Palette> paletteList = paletteService.getListPalettes();
        List<List<String>> list = new ArrayList<>();

        for (Palette palette:paletteList) {
            if(palette.getLigneCmdFour() == null) {
                list.add(palette.getInfo());
            }
        }
        return list;
    }

    @GetMapping("/listPalettesToRece")
    public List<String> getListPalettesToRece() {
        List<Palette> paletteList = paletteService.getListPalettes();
        List<String> list = new ArrayList<>();

        for (Palette palette:paletteList) {
            if(palette.getLigneCmdFour() != null && palette.getLigneRecepFour() == null) {
                list.add(palette.getNom());
            }
        }
        return list;
    }

    @PostMapping("/recFour/save/{paletteID}/{emplacementID}")
    public String postRecFour(@PathVariable int paletteID , @PathVariable int emplacementID) {
        Palette palette = paletteService.getPaletteByID(paletteID);
        Emplacement emplacement = emplacementService.getEmplacementByID(emplacementID);
        Fournisseur fournisseur = palette.getLigneCmdFour().getEnteteCmdFour().getFournisseur();

        EnteteRecepFour enteteRecepFour = new EnteteRecepFour();
        LigneRecepFour ligneRecepFour = new LigneRecepFour();
        EnteteFactFour enteteFactFour = new EnteteFactFour();
        LigneFactFour ligneFactFour = new LigneFactFour();

        enteteRecepFour.setFournisseur(fournisseur);
        enteteRecepFourService.saveEnteteRecep(enteteRecepFour);

        enteteFactFour.setFournisseur(fournisseur);
        enteteFactFourService.saveEnteteFact(enteteFactFour);

        ligneRecepFour.setEnteteRecepFour(enteteRecepFour);
        ligneRecepFour.setPalette(palette);
        ligneRecepFourService.saveLigneRecep(ligneRecepFour);

        ligneFactFour.setEnteteFactFour(enteteFactFour);
        ligneFactFour.setPalette(palette);
        ligneFactFourService.saveLigneFact(ligneFactFour);

        enteteRecepFour.setLigneRecepFour(ligneRecepFour);
        enteteRecepFourService.saveEnteteRecep(enteteRecepFour);

        enteteFactFour.setLigneFactFour(ligneFactFour);
        enteteFactFourService.saveEnteteFact(enteteFactFour);

        ligneRecepFour.setEnteteRecepFour(enteteRecepFour);
        ligneRecepFourService.saveLigneRecep(ligneRecepFour);

        ligneFactFour.setEnteteFactFour(enteteFactFour);
        ligneFactFourService.saveLigneFact(ligneFactFour);

        palette.setLigneRecepFour(ligneRecepFour);
        palette.setLigneFactFour(ligneFactFour);
        palette.setEmplacement(emplacement);
        paletteService.savePalette(palette);

        emplacement.setPalette(palette);
        emplacementService.saveEmplacement(emplacement);

        return "Réception bien enregistrée";
    }

    @GetMapping("/listFactures")
    public List<List<String>> getListFactures() {
        List<LigneFactFour> ligneFactFourList = ligneFactFourService.getListLigneFactFour();
        List<List<String>> list = new ArrayList<>();

        for (LigneFactFour ligneFacture:ligneFactFourList) {
            List<String> ligneFactFourInfo = new ArrayList<>();
            ligneFactFourInfo.add(Integer.toString(ligneFacture.getID()));
            ligneFactFourInfo.add(ligneFacture.getPalette().getNom());
            list.add(ligneFactFourInfo);
        }
        return list;
    }

    @GetMapping("/factureInfo/{id}")
    public List<String> getFactureInfo(@PathVariable int id) {
        LigneFactFour ligneFactFour = ligneFactFourService.findLigneFactByID(id);
        return ligneFactFour.getInfo();
    }

    @GetMapping("/ligneFactFour/{page}/{size}")
    public List<List<String>> getPageEmplacements(@PathVariable int page, @PathVariable int size){
        Page<LigneFactFour> ligneFactFourPage = ligneFactFourService.getPageLigneFactFour(page,size);
        List<List<String>> list = new ArrayList<>();

        for (LigneFactFour ligneFacture:ligneFactFourPage) {
            List<String> ligneFactFourInfo = new ArrayList<>();
            ligneFactFourInfo.add(Integer.toString(ligneFacture.getID()));
            ligneFactFourInfo.add(ligneFacture.getPalette().getNom());
            list.add(ligneFactFourInfo);
        }
        return list;
    }

    @GetMapping("/ligneFactFour/totalPages/{page}/{size}")
    public int getTotalPagesEmplacements(@PathVariable int page, @PathVariable int size){
        return ligneFactFourService.getPageLigneFactFour(page,size).getTotalPages();
    }
}
