package com.dourki.wms_backend.Web;

import com.dourki.wms_backend.Services.CategorieFournisseurService;
import com.dourki.wms_backend.Services.FournisseurService;
import com.dourki.wms_backend.entities.CategorieClient;
import com.dourki.wms_backend.entities.CategorieFournisseur;
import com.dourki.wms_backend.entities.Client;
import com.dourki.wms_backend.entities.Fournisseur;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class CategorieFournisseurRestAPI {

    private CategorieFournisseurService categorieFournisseurService;
    private FournisseurService fournisseurService;

    @PostMapping("/catFour/save/{categorieFournisseurName}")
    public String postCatFour(@PathVariable String categorieFournisseurName) {
        CategorieFournisseur categorie = categorieFournisseurService.getCategorieByNom(categorieFournisseurName);
        if(categorie == null){
            CategorieFournisseur categorieFournisseur = new CategorieFournisseur();
            categorieFournisseur.setNom(categorieFournisseurName);
            categorieFournisseurService.saveCategorie(categorieFournisseur);
            return "Catégorie ajoutée";
        }
        return "Catégorie existe déjà";
    }

    @GetMapping("/listCatFour/{page}/{size}")
    public List<String> getPageCatsFour(@PathVariable int page, @PathVariable int size){
        Page<CategorieFournisseur> categorieFournisseurPage = categorieFournisseurService.getCategories(page,size);
        List<String> catsFour = new ArrayList<>();
        categorieFournisseurPage.forEach(categorieFournisseur -> {catsFour.add(categorieFournisseur.getNom());});
        return catsFour;
    }

    @GetMapping("/listCatFour/totalPages/{page}/{size}")
    public int getTotalPagesCatsFour(@PathVariable int page, @PathVariable int size){
        int totalPages = categorieFournisseurService.getCategories(page,size).getTotalPages();
        return totalPages;
    }

    @PutMapping("/listCatFour/update/{id}/{categorieFourName}")
    public String updateCategorie(@PathVariable int id , @PathVariable String categorieFourName) {
        CategorieFournisseur categorieFournisseur = categorieFournisseurService.getCategorieByID(id);
        CategorieFournisseur categorieFournisseurByNom = categorieFournisseurService.getCategorieByNom(categorieFourName);
        if(categorieFournisseur != null && categorieFournisseurByNom == null)
        {
            categorieFournisseur.setNom(categorieFourName);
            categorieFournisseurService.saveCategorie(categorieFournisseur);
            return "Catégorie modifiée";
        }
        return "Catégorie non modifiée";
    }

    @DeleteMapping("/listCatFour/delete/{id}")
    public String deleteCategorie(@PathVariable int id ){
        CategorieFournisseur categorieFournisseur = categorieFournisseurService.getCategorieByID(id);
        List<Fournisseur> fournisseurs = fournisseurService.getListFournisseurs();
        for (Fournisseur fournisseur:fournisseurs) {
            if (fournisseur.getCategorie().getID() == id) {
                return "Impossible de supprimer cette catégorie, car elle est associée à un fournisseur";
            }
        }
        if(categorieFournisseur != null)
        {
            categorieFournisseurService.deleteCategorieByID(id);
            return "Catégorie supprimée";
        }
        return "Catégorie non supprimée";
    }

    @GetMapping("/listCatFour/getID/{categorieFourName}")
    public int getCategorieIDByNom(@PathVariable String categorieFourName){
        CategorieFournisseur categorieFournisseur = categorieFournisseurService.getCategorieByNom(categorieFourName);
        if(categorieFournisseur != null)
        {
            return categorieFournisseur.getID();
        }
        return -1;
    }

    @GetMapping("/listCatFour/getByID/{ID}")
    public CategorieFournisseur getCategorieByID(@PathVariable int ID) {
        return categorieFournisseurService.getCategorieByID(ID);
    }

    @GetMapping("/listCatFour/getAllCategoriesNames")
    public List<String> getListCategoriesNames(){
        List<CategorieFournisseur> categorieFournisseurs = categorieFournisseurService.getListCategories();
        List<String> listNames = new ArrayList<>();
        categorieFournisseurs.forEach(categorieFournisseur ->  {listNames.add(categorieFournisseur.getNom());});
        return listNames;
    }
}
