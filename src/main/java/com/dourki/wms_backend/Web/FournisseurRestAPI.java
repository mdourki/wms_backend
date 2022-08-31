package com.dourki.wms_backend.Web;

import com.dourki.wms_backend.Services.CategorieFournisseurService;
import com.dourki.wms_backend.Services.FournisseurService;
import com.dourki.wms_backend.entities.CategorieFournisseur;
import com.dourki.wms_backend.entities.Famille;
import com.dourki.wms_backend.entities.Fournisseur;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class FournisseurRestAPI {

    private FournisseurService fournisseurService;
    private CategorieFournisseurService categorieFournisseurService;

    @PostMapping("/fournisseurs/save/{nom}/{adresse}/{numTel}/{email}/{categorieID}")
    public String postFournisseur(@PathVariable String nom ,
                            @PathVariable String adresse ,
                            @PathVariable String numTel ,
                            @PathVariable String email ,
                            @PathVariable int categorieID ) {
        CategorieFournisseur categorieFournisseur = categorieFournisseurService.getCategorieByID(categorieID);
        Fournisseur fournisseur = fournisseurService.
                getFournisseurByNomAndAdresseAndNumTelAndEmail(nom , adresse , numTel , email);

        if(fournisseur == null){
            Fournisseur fournisseur1 = new Fournisseur();
            fournisseur1.setNom(nom);
            fournisseur1.setAdresse(adresse);
            fournisseur1.setNumTel(numTel);
            fournisseur1.setEmail(email);
            fournisseur1.setCategorie(categorieFournisseur);
            fournisseurService.saveFournisseur(fournisseur1);
            return "Fournisseur ajouté";
        }
        return "Fournisseur existe déjà";
    }

    @GetMapping("/fournisseurs/{page}/{size}")
    public List<List<String>> getPageFournisseurs(@PathVariable int page, @PathVariable int size){
        Page<Fournisseur> fournisseurPage = fournisseurService.getFournisseurs(page,size);
        List<List<String>> list = new ArrayList<>();
        fournisseurPage.forEach(fournisseur -> { list.add(fournisseur.getInfo()); });
        return list;
    }

    @GetMapping("/fournisseurs/totalPages/{page}/{size}")
    public int getTotalPagesFournisseurs(@PathVariable int page, @PathVariable int size){
        return fournisseurService.getFournisseurs(page,size).getTotalPages();
    }

    @PutMapping("/fournisseurs/update/{id}/{nom}/{adresse}/{numTel}/{email}/{categorieID}")
    public String updateFournisseur(@PathVariable int id ,
                               @PathVariable String nom ,
                               @PathVariable String adresse ,
                               @PathVariable String numTel ,
                               @PathVariable String email ,
                               @PathVariable int categorieID ) {
        Fournisseur fournisseur = fournisseurService.getFournisseurByID(id);
        CategorieFournisseur categorieFournisseur = categorieFournisseurService.getCategorieByID(categorieID);
        Fournisseur fournisseur1 = fournisseurService.
                getFournisseurByNomAndAdresseAndNumTelAndEmail(nom , adresse , numTel , email);
        if(fournisseur != null && fournisseur1 == null)
        {
            fournisseur.setNom(nom);
            fournisseur.setAdresse(adresse);
            fournisseur.setNumTel(numTel);
            fournisseur.setEmail(email);
            fournisseur.setCategorie(categorieFournisseur);
            fournisseurService.saveFournisseur(fournisseur);
            return "Fournisseur modifié";
        }
            return "Fournisseur non modifié";
    }

    @DeleteMapping("/fournisseurs/delete/{id}")
    public String deleteFournisseur(@PathVariable int id ){
        Fournisseur fournisseur = fournisseurService.getFournisseurByID(id);
        if(fournisseur != null)
        {
            fournisseurService.deleteFournisseurByID(id);
            return "Fournisseur supprimé";
        }
        return "Fournisseur non supprimé";
    }

    @GetMapping("/fournisseurs/getByID/{ID}")
    public Fournisseur getFournisseurByID(@PathVariable int ID) {
        return fournisseurService.getFournisseurByID(ID);
    }

    @GetMapping("/fournisseurs/getID/{fournisseurName}")
    public int getFournisseurIDByNom(@PathVariable String fournisseurName) {
        return fournisseurService.getFournisseurByNom(fournisseurName).getID();
    }

    @GetMapping("/fournisseurs/getAllFournisseursNames")
    public List<String> getFournisseursNames() {
        List<String> listNames = new ArrayList<>();
        List<Fournisseur> fournisseurs = fournisseurService.getListFournisseurs();
        for (Fournisseur fournisseur : fournisseurs){
            listNames.add(fournisseur.getNom());
        }
        return listNames;
    }

    @GetMapping("/fournisseursPrdts/{page}/{size}")
    public List<List<String>> getFournisseursPrdts(@PathVariable int page , @PathVariable int size){
        Page<Fournisseur> fournisseurPage = fournisseurService.getFournisseurs(page , size);
        List<List<String>> list = new ArrayList<>();
        fournisseurPage.forEach(fournisseur ->  {list.add(fournisseur.getInfoFourPrdts());});
        return list;
    }

    @GetMapping("/fournisseurs/stockGlobal/{page}/{size}")
    public List<List<String>> getPageFournisseursStockGlobal(@PathVariable int page, @PathVariable int size){
        Page<Fournisseur> fournisseurPage = fournisseurService.getFournisseurs(page,size);
        List<List<String>> list = new ArrayList<>();

        fournisseurPage.forEach(fournisseur -> {list.add(fournisseur.getQuantityInfo());});
        return list;
    }

}
