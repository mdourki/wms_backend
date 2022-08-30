package com.dourki.wms_backend.Web;

import com.dourki.wms_backend.Services.ProduitService;
import com.dourki.wms_backend.Services.StyleService;
import com.dourki.wms_backend.entities.Collection;
import com.dourki.wms_backend.entities.Famille;
import com.dourki.wms_backend.entities.Produit;
import com.dourki.wms_backend.entities.Style;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class StyleRestAPI {

    private StyleService styleService;
    private ProduitService produitService;

    @PostMapping("/styles/save/{styleName}")
    public String postStyle(@PathVariable String styleName) {
        Style style = styleService.getStyleByNom(styleName);
        if(style == null){
            Style style1 = new Style();
            style1.setNom(styleName);
            styleService.saveStyle(style1);
            return "Style ajouté";
        }
        return "Style existe déjà";
    }

    @GetMapping("/styles/{page}/{size}")
    public List<String> getPageStyles(@PathVariable int page, @PathVariable int size){
        Page<Style> stylePage = styleService.getStyles(page,size);
        List<String> styles = new ArrayList<>();
        stylePage.forEach(style -> {styles.add(style.getNom());});
        return styles;
    }

    @GetMapping("/styles/totalPages/{page}/{size}")
    public int getTotalPagesStyles(@PathVariable int page, @PathVariable int size){
        int totalPages = styleService.getStyles(page,size).getTotalPages();
        return totalPages;
    }

    @PutMapping("/styles/update/{id}/{styleName}")
    public String updateStyle(@PathVariable int id , @PathVariable String styleName) {
        Style style = styleService.getStyleByID(id);
        Style styleByNom = styleService.getStyleByNom(styleName);
        if(style != null && styleByNom == null)
        {
            style.setNom(styleName);
            styleService.saveStyle(style);
            return "Style modifié";
        }
        return "Style non modifié";
    }

    @DeleteMapping("/styles/delete/{id}")
    public String deleteStyle(@PathVariable int id ){
        Style style = styleService.getStyleByID(id);
        List<Produit> produits = produitService.getListProduits();
        for (Produit produit:produits) {
            if (produit.getStyle().getID() == id) {
                return "Impossible de supprimer ce style, car il est associé à un produit";
            }
        }
        if(style != null)
        {
            styleService.deleteStyleByID(id);
            return "Style supprimé";
        }
        return "Style non supprimé";
    }

    @GetMapping("/styles/getID/{styleName}")
    public int getStyleIDByNom(@PathVariable String styleName){
        Style style = styleService.getStyleByNom(styleName);
        if(style != null)
        {
            return style.getID();
        }
        return -1;
    }

    @GetMapping("/styles/getByID/{ID}")
    public Style getStyleByID(@PathVariable int ID) {
        return styleService.getStyleByID(ID);
    }

    @GetMapping("/styles/getAllStylesNames")
    public List<String> getListStylesNames(){
        List<Style> styleList = styleService.getListStyles();
        List<String> listNames = new ArrayList<>();
        styleList.forEach(style ->  {listNames.add(style.getNom());});
        return listNames;
    }
}
