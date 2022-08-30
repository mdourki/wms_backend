package com.dourki.wms_backend.Web;

import com.dourki.wms_backend.Services.DepotService;
import com.dourki.wms_backend.Services.EmplacementService;
import com.dourki.wms_backend.Services.PaletteService;
import com.dourki.wms_backend.Services.ProduitService;
import com.dourki.wms_backend.entities.Depot;
import com.dourki.wms_backend.entities.Emplacement;
import com.dourki.wms_backend.entities.Palette;
import com.dourki.wms_backend.entities.Produit;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class PaletteRestAPI {

    private PaletteService paletteService;
    private ProduitService produitService;

    @PostMapping("/palettes/save/{nom}/{numSerie}/{quantity}/{codeProduit}")
    public String postPalette(@PathVariable String nom ,
                            @PathVariable String numSerie ,
                            @PathVariable Integer quantity ,
                            @PathVariable String codeProduit ) {
        Produit produit = produitService.getPrdtByCodePrdt(codeProduit);
        Palette palette = paletteService.
                getPaletteByNomAndNumeroSerie(nom,numSerie);

        if(palette == null){
            Palette palette1 = new Palette();
            palette1.setNom(nom);
            palette1.setNumeroSerie(numSerie);
            palette1.setQuantity(quantity);
            palette1.setProduit(produit);
            paletteService.savePalette(palette1);
            return "Palette ajoutée";
        }
        return "Palette existe déjà";
    }

    @GetMapping("/palettes/{page}/{size}")
    public List<List<String>> getPagePalettes(@PathVariable int page, @PathVariable int size){
        Page<Palette> palettePage = paletteService.getPalettes(page,size);
        List<List<String>> list = new ArrayList<>();
        palettePage.forEach(palette -> { list.add(palette.getInfo()); });
        return list;
    }

    @GetMapping("/palettes/totalPages/{page}/{size}")
    public int getTotalPagesPalettes(@PathVariable int page, @PathVariable int size){
        return paletteService.getPalettes(page,size).getTotalPages();
    }

    @GetMapping("/palettes/getIdByNumSerie/{numSerie}")
    public int getIdByNumSerie(@PathVariable String numSerie) {
        return paletteService.getPaletteByNumeroSerie(numSerie).getID();
    }

    @GetMapping("/palettes/getIdByNom/{nom}")
    public int getIdByNom(@PathVariable String nom) {
        return paletteService.getPaletteByNom(nom).getID();
    }
}
