package com.dourki.wms_backend.Web;

import com.dourki.wms_backend.Services.DepotService;
import com.dourki.wms_backend.Services.EmplacementService;
import com.dourki.wms_backend.entities.Client;
import com.dourki.wms_backend.entities.Depot;
import com.dourki.wms_backend.entities.Emplacement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class DepotRestAPI {

    private DepotService depotService;
    private EmplacementService emplacementService;

    @PostMapping("/depots/save/{libelle}/{adresse}")
    public String postDepot(@PathVariable String libelle , @PathVariable String adresse) {
        Depot depot = depotService.getDepotByLibelle(libelle);
        if(depot == null){
            Depot depot1 = new Depot();
            depot1.setLibelle(libelle);
            depot1.setAdresse(adresse);
            depotService.saveDepot(depot1);
            return "Dépôt ajouté";
        }
        return "Dépôt existe déjà";
    }

    @GetMapping("/depots/{page}/{size}")
    public List<List<String>> getPageDepots(@PathVariable int page, @PathVariable int size){
        Page<Depot> depotPage = depotService.getDepots(page,size);
        List<List<String>> list = new ArrayList<>();
        depotPage.forEach(depot -> { list.add(depot.getInfo()); });
        return list;
    }

    @GetMapping("/depots/totalPages/{page}/{size}")
    public int getTotalPagesDepots(@PathVariable int page, @PathVariable int size){
        return depotService.getDepots(page,size).getTotalPages();
    }

    @PutMapping("/depots/update/{id}/{libelle}/{adresse}")
    public String updateDepot(@PathVariable int id ,
                               @PathVariable String libelle ,
                               @PathVariable String adresse) {
        Depot depot = depotService.getDepotByID(id);
        Depot depotByLibelle = depotService.getDepotByLibelle(libelle);
        if(depot != null && depotByLibelle == null)
        {
            depot.setLibelle(libelle);
            depot.setAdresse(adresse);
            depotService.saveDepot(depot);
            return "Dépôt modifié";
        }
        return "Dépôt non modifié";
    }

    @DeleteMapping("/depots/delete/{id}")
    public String deleteDepot(@PathVariable int id ){
        Depot depot = depotService.getDepotByID(id);
        List<Emplacement> emplacementList = emplacementService.getListEmplacements();
        for (Emplacement emplacement:emplacementList) {
            if (emplacement.getDepot().getID() == id) {
                return "Impossible de supprimer ce dépot, car il est associée à un emplacement";
            }
        }
        if(depot != null)
        {
            depotService.deleteDepotByID(id);
            return "Dépôt supprimé";
        }
        return "Dépôt non supprimé";
    }

    @GetMapping("/depots/getID/{libelle}")
    public int getDepotIDByLibelle(@PathVariable String libelle){
        Depot depot = depotService.getDepotByLibelle(libelle);
        if(depot != null)
        {
            return depot.getID();
        }
        return -1;
    }

    @GetMapping("/depots/getDepotLibelleByID/{ID}")
    public String getDepotLibelleByID(@PathVariable int ID) {
        return depotService.getDepotByID(ID).getLibelle();
    }

    @GetMapping("depots/getAllDepotsLibelle")
    public List<String> getLibelleDepotList() {
        List<Depot> depots = depotService.getListDepots();
        List<String> listLibelles = new ArrayList<>();
        depots.forEach(depot -> {listLibelles.add(depot.getLibelle());});
        return listLibelles;
    }

}
