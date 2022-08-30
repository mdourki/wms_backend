package com.dourki.wms_backend.Web;

import com.dourki.wms_backend.Services.DepotService;
import com.dourki.wms_backend.Services.EmplacementService;
import com.dourki.wms_backend.Services.PaletteService;
import com.dourki.wms_backend.entities.Depot;
import com.dourki.wms_backend.entities.Emplacement;
import com.dourki.wms_backend.entities.Palette;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class EmplacementRestAPI {

    private EmplacementService emplacementService;
    private DepotService depotService;
    private PaletteService paletteService;

    @PostMapping("/emplacements/save/{allee}/{nivHoriz}/{nivVerti}/{depotID}")
    public String postEmplacement(@PathVariable String allee ,
                            @PathVariable String nivHoriz ,
                            @PathVariable String nivVerti ,
                            @PathVariable int depotID ) {
        Depot depot = depotService.getDepotByID(depotID);
        Emplacement emplacement = emplacementService.
                getEmplacementByAlleeAndNivHorizAndNivVertiAndDepot(allee,nivHoriz,nivVerti,depot);

        if(emplacement == null){
            Emplacement emplacement1 = new Emplacement();
            emplacement1.setAllee(allee);
            emplacement1.setNivHoriz(nivHoriz);
            emplacement1.setNivVerti(nivVerti);
            emplacement1.setDepot(depot);
            emplacementService.saveEmplacement(emplacement1);
            return "Emplacement ajouté";
        }
        return "Emplacement existe déjà";
    }

    @GetMapping("/emplacements/{page}/{size}")
    public List<List<String>> getPageEmplacements(@PathVariable int page, @PathVariable int size){
        Page<Emplacement> emplacementPage = emplacementService.getEmplacements(page,size);
        List<List<String>> list = new ArrayList<>();
        emplacementPage.forEach(emplacement -> { list.add(emplacement.getInfo()); });
        return list;
    }

    @GetMapping("/emplacements/getListByDepot/{id}")
    public List<List<String>> getListEmplacementsByDepot(@PathVariable int id){
        Depot depot = depotService.getDepotByID(id);
        List<List<String>> list = new ArrayList<>();
        List<Emplacement> emplacementList = emplacementService.getEmplacementsByDepot(depot);
        for (Emplacement emplacement:emplacementList) {
            list.add(emplacement.getInfo());
        }
        return list;
    }

    @GetMapping("/emplacements/totalPages/{page}/{size}")
    public int getTotalPagesEmplacements(@PathVariable int page, @PathVariable int size){
        return emplacementService.getEmplacements(page,size).getTotalPages();
    }

    @PutMapping("/emplacements/update/{id}/{allee}/{nivHoriz}/{nivVerti}/{depotID}")
    public String updateEmplacement(@PathVariable int id ,
                                    @PathVariable String allee ,
                                    @PathVariable String nivHoriz ,
                                    @PathVariable String nivVerti ,
                                    @PathVariable int depotID ) {
        Emplacement emplacement = emplacementService.getEmplacementByID(id);
        Depot depot = depotService.getDepotByID(depotID);
        Emplacement emplacement1 = emplacementService.
                getEmplacementByAlleeAndNivHorizAndNivVertiAndDepot(allee,nivHoriz,nivVerti,depot);
        if(emplacement != null && emplacement1 == null)
        {
            emplacement.setAllee(allee);
            emplacement.setNivHoriz(nivHoriz);
            emplacement.setNivVerti(nivVerti);
            emplacement.setDepot(depot);
            emplacementService.saveEmplacement(emplacement);
            return "Emplacement modifié";
        }
            return "Emplacement non modifié";
    }

    @DeleteMapping("/emplacements/delete/{id}")
    public String deleteEmplacement(@PathVariable int id ){
        Emplacement emplacement = emplacementService.getEmplacementByID(id);
        List<Palette> paletteList = paletteService.getListPalettes();
        for (Palette palette:paletteList) {
            if (palette.getEmplacement() != null && palette.getEmplacement().getID() == id) {
                return "Impossible de supprimer cet emplacement, car il est contient une palette";
            }
        }
        if(emplacement != null)
        {
            emplacementService.deleteEmplacementByID(id);
            return "Emplacement supprimé";
        }
        return "Emplacement non supprimé";
    }

    @GetMapping("/emplacements/getByID/{ID}")
    public Emplacement getEmplacementByID(@PathVariable int ID) {
        return emplacementService.getEmplacementByID(ID);
    }

    @GetMapping("/emplacements/getEmplacementsToStock")
    public List<List<String>> getEmplacementsToStock() {
        List<Emplacement> emplacementList = emplacementService.getListEmplacements();
        List<List<String>> list = new ArrayList<>();
        for (Emplacement emplacement:emplacementList) {
            if(emplacement.getPalette() == null) {
                list.add(emplacement.getInfo());
            }
        }
        return list;
    }


}
