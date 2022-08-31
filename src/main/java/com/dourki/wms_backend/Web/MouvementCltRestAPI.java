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
public class MouvementCltRestAPI {

    PaletteService paletteService;
    ClientService clientService;
    EnteteCmdCltService enteteCmdCltService;
    LigneCmdCltService ligneCmdCltService;
    EmplacementService emplacementService;
    EnteteLivCltService enteteLivCltService;
    LigneLivCltService ligneLivCltService;
    EnteteFactCltService enteteFactCltService;
    LigneFactCltService ligneFactCltService;

    @PostMapping("/cmdClt/save/{paletteID}/{clientID}")
    public String postCmdClt(@PathVariable int paletteID , @PathVariable int clientID) {
        Palette palette = paletteService.getPaletteByID(paletteID);
        Client client = clientService.getClientByID(clientID);

        if(palette.getLigneCmdClt()!=null && palette.getLigneCmdClt().getEnteteCmdClt().getClient().getID() == clientID) {
            return "Cette palette est déjà enregistrée dans une commande";
        }

        EnteteCmdClt enteteCmdClt = new EnteteCmdClt();
        LigneCmdClt ligneCmdClt = new LigneCmdClt();

        enteteCmdClt.setClient(client);
        enteteCmdCltService.saveEnteteCmd(enteteCmdClt);

        ligneCmdClt.setEnteteCmdClt(enteteCmdClt);
        ligneCmdClt.setPalette(palette);
        ligneCmdCltService.saveLigneCmd(ligneCmdClt);

        enteteCmdClt.setLigneCmdClt(ligneCmdClt);
        enteteCmdCltService.saveEnteteCmd(enteteCmdClt);

        ligneCmdClt.setEnteteCmdClt(enteteCmdClt);
        ligneCmdCltService.saveLigneCmd(ligneCmdClt);

        palette.setLigneCmdClt(ligneCmdClt);
        paletteService.savePalette(palette);

        return "Commande bien enregistrée";
    }

    @GetMapping("/listPalettesToLiv")
    public List<List<String>> getListPalettesToLiv() {
        List<Palette> paletteList = paletteService.getListPalettes();
        List<List<String>> list = new ArrayList<>();

        for (Palette palette:paletteList) {
            if(palette.getLigneCmdClt() == null && palette.getEmplacement() != null && palette.getLigneCmdFour() != null ) {
                list.add(palette.getInfo());
            }
        }
        return list;
    }

    @PostMapping("/livClt/save/{cmdID}")
    public String postLivClt(@PathVariable int cmdID) {
        LigneCmdClt ligneCmdClt = ligneCmdCltService.findLigneCmdByID(cmdID);
        Palette palette = ligneCmdClt.getPalette();
        Emplacement emplacement = palette.getEmplacement();
        Client client = ligneCmdClt.getEnteteCmdClt().getClient();

        EnteteLivClt enteteLivClt = new EnteteLivClt();
        LigneLivClt ligneLivClt = new LigneLivClt();
        EnteteFactClt enteteFactClt = new EnteteFactClt();
        LigneFactClt ligneFactClt = new LigneFactClt();

        enteteLivClt.setClient(client);
        enteteLivCltService.saveEnteteLiv(enteteLivClt);

        enteteFactClt.setClient(client);
        enteteFactCltService.saveEnteteFact(enteteFactClt);

        ligneLivClt.setEnteteLivClt(enteteLivClt);
        ligneLivClt.setPalette(palette);
        ligneLivCltService.saveLigneRecep(ligneLivClt);

        ligneFactClt.setEnteteFactClt(enteteFactClt);
        ligneFactClt.setPalette(palette);
        ligneFactCltService.saveLigneFact(ligneFactClt);

        enteteLivClt.setLigneLivClt(ligneLivClt);
        enteteLivCltService.saveEnteteLiv(enteteLivClt);

        enteteFactClt.setLigneFactClt(ligneFactClt);
        enteteFactCltService.saveEnteteFact(enteteFactClt);

        ligneLivClt.setEnteteLivClt(enteteLivClt);
        ligneLivCltService.saveLigneRecep(ligneLivClt);

        ligneFactClt.setEnteteFactClt(enteteFactClt);
        ligneFactCltService.saveLigneFact(ligneFactClt);

        palette.setLigneLivClt(ligneLivClt);
        palette.setLigneFactClt(ligneFactClt);
        palette.setEmplacement(null);
        paletteService.savePalette(palette);

        emplacement.setPalette(null);
        emplacementService.saveEmplacement(emplacement);

        return "Livraison bien enregistrée";
    }

    @GetMapping("/listFacturesClt")
    public List<List<String>> getListFactures() {
        List<LigneFactClt> ligneFactCltList = ligneFactCltService.getListLigneFactClt();
        List<List<String>> list = new ArrayList<>();

        for (LigneFactClt ligneFacture:ligneFactCltList) {
            List<String> ligneFactCltInfo = new ArrayList<>();
            ligneFactCltInfo.add(Integer.toString(ligneFacture.getID()));
            ligneFactCltInfo.add(ligneFacture.getPalette().getNom());
            list.add(ligneFactCltInfo);
        }
        return list;
    }

    @GetMapping("/factureCltInfo/{id}")
    public List<String> getFactureInfo(@PathVariable int id) {
        LigneFactClt ligneFactClt = ligneFactCltService.findLigneFactByID(id);
        return ligneFactClt.getInfo();
    }

    @GetMapping("/ligneFactClt/{page}/{size}")
    public List<List<String>> getPageFactures(@PathVariable int page, @PathVariable int size){
        Page<LigneFactClt> ligneFactCltPage = ligneFactCltService.getPageLigneFactClt(page,size);
        List<List<String>> list = new ArrayList<>();

        for (LigneFactClt ligneFacture:ligneFactCltPage) {
            List<String> ligneFactCltInfo = new ArrayList<>();
            ligneFactCltInfo.add(Integer.toString(ligneFacture.getID()));
            ligneFactCltInfo.add(ligneFacture.getPalette().getNom());
            list.add(ligneFactCltInfo);
        }
        return list;
    }

    @GetMapping("/ligneFactClt/totalPages/{page}/{size}")
    public int getTotalPagesFactures(@PathVariable int page, @PathVariable int size){
        return ligneFactCltService.getPageLigneFactClt(page,size).getTotalPages();
    }

    @GetMapping("/ligneCmdClt/{page}/{size}")
    public List<List<String>> getPageCommandesToLiv(@PathVariable int page, @PathVariable int size){
        Page<LigneCmdClt> ligneCmdCltPage = ligneCmdCltService.getPageLigneCmdClt(page,size);
        List<List<String>> list = new ArrayList<>();

        for (LigneCmdClt ligneCmdClt:ligneCmdCltPage) {
            if(ligneCmdClt.getPalette().getEmplacement() != null){
                List<String> ligneCmdCltInfo = new ArrayList<>();
                ligneCmdCltInfo.add(Integer.toString(ligneCmdClt.getID()));
                ligneCmdCltInfo.add(ligneCmdClt.getPalette().getNom());
                list.add(ligneCmdCltInfo);
            }
        }
        return list;
    }

    @GetMapping("/ligneCmdClt/totalPages/{page}/{size}")
    public int getTotalPagesCommandesToLiv(@PathVariable int page, @PathVariable int size){
        return ligneCmdCltService.getPageLigneCmdClt(page,size).getTotalPages();
    }
}
