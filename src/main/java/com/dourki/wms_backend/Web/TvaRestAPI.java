package com.dourki.wms_backend.Web;

import com.dourki.wms_backend.Services.ProduitService;
import com.dourki.wms_backend.Services.TvaService;
import com.dourki.wms_backend.entities.Collection;
import com.dourki.wms_backend.entities.Produit;
import com.dourki.wms_backend.entities.TVA;
import com.dourki.wms_backend.entities.Taille;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class TvaRestAPI {

    private TvaService tvaService;
    private ProduitService produitService;

    @PostMapping("/tvaList/save/{taux}")
    public String postTVA(@PathVariable float taux) {
        TVA tva = tvaService.getTvaByTaux(taux);
        if(tva == null){
            TVA tva1 = new TVA();
            tva1.setTaux(taux);
            tvaService.saveTva(tva1);
            return "TVA ajoutée";
        }
        return "TVA existe déjà";
    }

    @GetMapping("/tvaList/{page}/{size}")
    public List<Float> getPageTVAs(@PathVariable int page, @PathVariable int size){
        Page<TVA> tvaPage = tvaService.getTVAs(page,size);
        List<Float> tvas = new ArrayList<>();
        tvaPage.forEach(tva -> {tvas.add(tva.getTaux());});
        return tvas;
    }

    @GetMapping("/tvaList/totalPages/{page}/{size}")
    public int getTotalPagesTVAs(@PathVariable int page, @PathVariable int size){
        int totalPages = tvaService.getTVAs(page,size).getTotalPages();
        return totalPages;
    }

    @PutMapping("/tvaList/update/{id}/{taux}")
    public String updateTVA(@PathVariable int id , @PathVariable float taux) {
        TVA tva = tvaService.getTvaByID(id);
        TVA tvaByNom = tvaService.getTvaByTaux(taux);
        if(tva != null && tvaByNom == null)
        {
            tva.setTaux(taux);
            tvaService.saveTva(tva);
            return "TVA modifiée";
        }
        return "TVA non modifiée";
    }

    @DeleteMapping("/tvaList/delete/{id}")
    public String deleteTVA(@PathVariable int id ){
        TVA tva = tvaService.getTvaByID(id);
        List<Produit> produits = produitService.getListProduits();
        for (Produit produit:produits) {
            if (produit.getTva().getID() == id) {
                return "Impossible de supprimer cette TVA, car elle est associée à un produit";
            }
        }
        if(tva != null)
        {
            tvaService.deleteTvaByID(id);
            return "TVA supprimée";
        }
        return "TVA non supprimée";
    }

    @GetMapping("/tvaList/getID/{taux}")
    public int getTVAIDByNom(@PathVariable float taux){
        TVA tva = tvaService.getTvaByTaux(taux);
        if(tva != null)
        {
            return tva.getID();
        }
        return -1;
    }

    @GetMapping("/tvaList/getByID/{ID}")
    public TVA getTVAByID(@PathVariable int ID) {
        return tvaService.getTvaByID(ID);
    }

    @GetMapping("/tvaList/getAllTvaTaux")
    public List<Float> getListTvaTaux(){
        List<TVA> tvaList = tvaService.getListTVA();
        List<Float> listTaux = new ArrayList<>();
        tvaList.forEach(tva ->  {listTaux.add(tva.getTaux());});
        return listTaux;
    }
}
