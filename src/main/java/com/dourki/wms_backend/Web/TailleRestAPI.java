package com.dourki.wms_backend.Web;

import com.dourki.wms_backend.Services.ProduitService;
import com.dourki.wms_backend.Services.TailleService;
import com.dourki.wms_backend.entities.Couleur;
import com.dourki.wms_backend.entities.Produit;
import com.dourki.wms_backend.entities.Style;
import com.dourki.wms_backend.entities.Taille;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class TailleRestAPI {
    private TailleService tailleService;
    private ProduitService produitService;

    @PostMapping("/tailles/save/{tailleName}/{tailleCode}")
    public String postTaille(@PathVariable String tailleName , @PathVariable String tailleCode) {
        Taille taille = tailleService.getTailleByCode(tailleCode);
        Taille taille2 = tailleService.getTailleByNom(tailleName);
        if(taille == null && taille2 == null){
            Taille taille1 = new Taille();
            taille1.setCodeTaille(tailleCode);
            taille1.setNom(tailleName);
            tailleService.saveTaille(taille1);
            return "Taille ajoutée";
        }
        return "Taille existe déjà";
    }

    @GetMapping("/tailles/{page}/{size}")
    public List<List<String>> getPageTailles(@PathVariable int page, @PathVariable int size){
        Page<Taille> taillePage = tailleService.getTailles(page,size);
        List<List<String>> list = new ArrayList<>();
        taillePage.forEach(taille -> { list.add(taille.getInfo()); });
        return list;
    }

    @GetMapping("/tailles/totalPages/{page}/{size}")
    public int getTotalPagesTailles(@PathVariable int page, @PathVariable int size){
        return tailleService.getTailles(page,size).getTotalPages();
    }

    @PutMapping("/tailles/update/{id}/{codeTaille}/{tailleName}")
    public String updateTaille(@PathVariable int id ,
                               @PathVariable String codeTaille ,
                               @PathVariable String tailleName) {
        Taille taille = tailleService.getTailleByID(id);
        Taille taille1 = tailleService.getTailleByCode(codeTaille);
        Taille taille2 = tailleService.getTailleByNom(tailleName);
        if(taille != null && taille1 == null && taille2 == null)
        {
            taille.setCodeTaille(codeTaille);
            taille.setNom(tailleName);
            tailleService.saveTaille(taille);
            return "Taille modifiée";
        }
        return "Taille non modifiée";
    }

    @DeleteMapping("/tailles/delete/{id}")
    public String deleteTaille(@PathVariable int id ){
        Taille taille = tailleService.getTailleByID(id);
        List<Produit> produits = produitService.getListProduits();
        for (Produit produit:produits) {
            if (produit.getTaille().getID() == id) {
                return "Impossible de supprimer cette taille, car elle est associée à un produit";
            }
        }
        if(taille != null)
        {
            tailleService.deleteTailleByID(id);
            return "Taille supprimée";
        }
        return "Taille non supprimée";
    }

    @GetMapping("/tailles/getID/{codeTaille}")
    public int getTailleIDByCode(@PathVariable String codeTaille){
        Taille taille = tailleService.getTailleByCode(codeTaille);
        if(taille != null)
        {
            return taille.getID();
        }
        return -1;
    }

    @GetMapping("/tailles/getByID/{ID}")
    public Taille getTailleByID(@PathVariable int ID) {
        return tailleService.getTailleByID(ID);
    }

    @GetMapping("/tailles/getAllTaillesNames")
    public List<String> getListTaillesNames(){
        List<Taille> tailleList = tailleService.getListTailles();
        List<String> listNames = new ArrayList<>();
        tailleList.forEach(taille ->  {listNames.add(taille.getNom());});
        return listNames;
    }

}
