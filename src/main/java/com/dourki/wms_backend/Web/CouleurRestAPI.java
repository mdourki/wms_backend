package com.dourki.wms_backend.Web;

import com.dourki.wms_backend.Services.CouleurService;
import com.dourki.wms_backend.Services.ProduitService;
import com.dourki.wms_backend.entities.Collection;
import com.dourki.wms_backend.entities.Couleur;
import com.dourki.wms_backend.entities.Produit;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class CouleurRestAPI {
    private CouleurService couleurService;
    private ProduitService produitService;

    @PostMapping("/couleurs/save/{couleurName}/{couleurCode}")
    public String postCouleur(@PathVariable String couleurName , @PathVariable String couleurCode) {
        Couleur couleur = couleurService.getCouleurByCode(couleurCode);
        Couleur couleur2 = couleurService.getCouleurByNom(couleurName);
        if(couleur == null && couleur2 == null){
            Couleur couleur1 = new Couleur();
            couleur1.setCodeClr(couleurCode);
            couleur1.setNom(couleurName);
            couleurService.saveCouleur(couleur1);
            return "Couleur ajoutée";
        }
        return "Couleur existe déjà";
    }

    @GetMapping("/couleurs/{page}/{size}")
    public List<List<String>> getPageCouleurs(@PathVariable int page, @PathVariable int size){
        Page<Couleur> couleurPage = couleurService.getCouleurs(page,size);
        List<List<String>> list = new ArrayList<>();
        couleurPage.forEach(couleur -> { list.add(couleur.getInfo()); });
        return list;
    }

    @GetMapping("/couleurs/totalPages/{page}/{size}")
    public int getTotalPagesCouleurs(@PathVariable int page, @PathVariable int size){
        return couleurService.getCouleurs(page,size).getTotalPages();
    }

    @PutMapping("/couleurs/update/{id}/{codeCouleur}/{couleurName}")
    public String updateCouleur(@PathVariable int id ,
                               @PathVariable String codeCouleur ,
                               @PathVariable String couleurName) {
        Couleur couleur = couleurService.getCouleurByID(id);
        Couleur couleur1 = couleurService.getCouleurByCode(codeCouleur);
        Couleur couleur2 = couleurService.getCouleurByNom(couleurName);
        if(couleur != null && couleur1 == null && couleur2 == null)
        {
            couleur.setCodeClr(codeCouleur);
            couleur.setNom(couleurName);
            couleurService.saveCouleur(couleur);
            return "Couleur modifiée";
        }
        return "Couleur non modifiée";
    }

    @DeleteMapping("/couleurs/delete/{id}")
    public String deleteCouleur(@PathVariable int id ){
        Couleur couleur = couleurService.getCouleurByID(id);
        List<Produit> produits = produitService.getListProduits();
        for (Produit produit:produits) {
            if (produit.getCouleur().getID() == id) {
                return "Impossible de supprimer cette couleur, car elle est associée à un produit";
            }
        }
        if(couleur != null)
        {
            couleurService.deleteCouleurByID(id);
            return "Couleur supprimée";
        }
        return "Couleur non supprimée";
    }

    @GetMapping("/couleurs/getID/{codeCouleur}")
    public int getCouleurIDByCode(@PathVariable String codeCouleur){
        Couleur couleur = couleurService.getCouleurByCode(codeCouleur);
        if(couleur != null)
        {
            return couleur.getID();
        }
        return -1;
    }

    @GetMapping("/couleurs/getByID/{ID}")
    public Couleur getCouleurByID(@PathVariable int ID) {
        return couleurService.getCouleurByID(ID);
    }

    @GetMapping("/couleurs/getAllCouleursNames")
    public List<String> getListCouleursNames(){
        List<Couleur> couleurList = couleurService.getListCouleurs();
        List<String> listNames = new ArrayList<>();
        couleurList.forEach(couleur ->  {listNames.add(couleur.getNom());});
        return listNames;
    }

}
