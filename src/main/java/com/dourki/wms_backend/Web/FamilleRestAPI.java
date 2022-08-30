package com.dourki.wms_backend.Web;

import com.dourki.wms_backend.Services.FamilleService;
import com.dourki.wms_backend.Services.ProduitService;
import com.dourki.wms_backend.entities.Collection;
import com.dourki.wms_backend.entities.Famille;
import com.dourki.wms_backend.entities.Produit;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class FamilleRestAPI {
    private FamilleService familleService;
    private ProduitService produitService;

    @PostMapping("/familles/save/{familleName}")
    public String postFamille(@PathVariable String familleName) {
        Famille famille = familleService.getFamilleByNom(familleName);
        if(famille == null){
            Famille famille1 = new Famille();
            famille1.setNom(familleName);
            familleService.saveFamille(famille1);
            return "Famille ajoutée";
        }
        return "Famille existe déjà";
    }

    @GetMapping("/familles/{page}/{size}")
    public List<String> getPageFamilles(@PathVariable int page, @PathVariable int size){
        Page<Famille> famillePage = familleService.getFamilles(page,size);
        List<String> familles = new ArrayList<>();
        famillePage.forEach(famille -> {familles.add(famille.getNom());});
        return familles;
    }

    @GetMapping("/familles/totalPages/{page}/{size}")
    public int getTotalPagesFamilles(@PathVariable int page, @PathVariable int size){
        int totalPages = familleService.getFamilles(page,size).getTotalPages();
        return totalPages;
    }

    @PutMapping("/familles/update/{id}/{familleName}")
    public String updateFamille(@PathVariable int id , @PathVariable String familleName) {
        Famille famille = familleService.getFamilleByID(id);
        Famille familleByNom = familleService.getFamilleByNom(familleName);
        if(famille != null && familleByNom == null)
        {
            famille.setNom(familleName);
            familleService.saveFamille(famille);
            return "Famille modifiée";
        }
        return "Famille non modifiée";
    }

    @DeleteMapping("/familles/delete/{id}")
    public String deleteFamille(@PathVariable int id ){
        Famille famille = familleService.getFamilleByID(id);
        List<Produit> produits = produitService.getListProduits();
        for (Produit produit:produits) {
            if (produit.getFamille().getID() == id) {
                return "Impossible de supprimer cette famille, car elle est associée à un produit";
            }
        }
        if(famille != null)
        {
            familleService.deleteFamilleByID(id);
            return "Famille supprimée";
        }
        return "Famille non supprimée";
    }

    @GetMapping("/familles/getID/{familleName}")
    public int getFamilleIDByNom(@PathVariable String familleName){
        Famille famille = familleService.getFamilleByNom(familleName);
        if(famille != null)
        {
            return famille.getID();
        }
        return -1;
    }

    @GetMapping("/familles/getByID/{ID}")
    public Famille getFamilleByID(@PathVariable int ID) {
        return familleService.getFamilleByID(ID);
    }

    @GetMapping("/familles/getAllFamillesNames")
    public List<String> getListFamillesNames(){
        List<Famille> familleList = familleService.getListFamilles();
        List<String> listNames = new ArrayList<>();
        familleList.forEach(famille ->  {listNames.add(famille.getNom());});
        return listNames;
    }

    @GetMapping("/famillesPrdts/{page}/{size}")
    public List<List<String>> getFamillesPrdts(@PathVariable int page , @PathVariable int size){
        Page<Famille> famillePage = familleService.getFamilles(page , size);
        List<List<String>> list = new ArrayList<>();
        famillePage.forEach(famille ->  {list.add(famille.infoFamillePrdts());});
        return list;
    }
}
