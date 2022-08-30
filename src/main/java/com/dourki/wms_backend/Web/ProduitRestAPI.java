package com.dourki.wms_backend.Web;

import com.dourki.wms_backend.Exceptions.ProduitNotFoundException;
import com.dourki.wms_backend.Services.*;
import com.dourki.wms_backend.entities.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class ProduitRestAPI {

    private ProduitService produitService;
    private CouleurService couleurService;
    private TailleService tailleService;
    private FamilleService familleService;
    private CollectionService collectionService;
    private StyleService styleService;
    private TvaService tvaService;

    @GetMapping("/produits/{produitCodeBarre}")
    public String getProdtCodeBarre(@PathVariable String produitCodeBarre) throws ProduitNotFoundException {
        Produit produit = produitService.getPrdt(produitCodeBarre);
        return produit.toString();
    }

    @PostMapping("/produits/save/{nom}/{couleurs}/{tailles}/{nomFamille}/{nomCollection}/{nomStyle}/{tvaTaux}" +
            "/{codeBarre}/{designation}/{prixUnit}/{prixTTC}")
    public String postProduit(@PathVariable String nom , @PathVariable String couleurs ,
                              @PathVariable String tailles , @PathVariable String nomFamille ,
                              @PathVariable String nomCollection , @PathVariable String nomStyle ,
                              @PathVariable Float tvaTaux , @PathVariable String codeBarre ,
                              @PathVariable String designation , @PathVariable Float prixUnit ,
                              @PathVariable Float prixTTC) {
        String[] clrNames = couleurs.split(",");
        String[] clrTailles = tailles.split(",");
        List<Couleur> listCouleurs = new ArrayList<>();
        List<Taille> listTailles = new ArrayList<>();
        for(String c : clrNames){
            listCouleurs.add(couleurService.getCouleurByNom(c));
        }
        for(String t : clrTailles){
            listTailles.add(tailleService.getTailleByNom(t));
        }
        Famille famille = familleService.getFamilleByNom(nomFamille);
        Collection collection = collectionService.getCollectionByNom(nomCollection);
        Style style = styleService.getStyleByNom(nomStyle);
        TVA tva = tvaService.getTvaByTaux(tvaTaux);
        List<Produit> prdtsList = produitService.getPrdtsByNom(nom);

        if(prdtsList.isEmpty()) {
            for (Couleur couleur:listCouleurs) {
                for (Taille taille:listTailles) {
                    Produit produit = new Produit();
                    produit.setNom(nom);
                    produit.setCodePrdt(nom+"-"+couleur.getCodeClr()+"-"+taille.getCodeTaille());
                    produit.setCodeBarre(codeBarre);
                    produit.setDesignation(designation);
                    produit.setFamille(famille);
                    produit.setCollection(collection);
                    produit.setStyle(style);
                    produit.setCouleur(couleur);
                    produit.setTaille(taille);
                    produit.setTva(tva);
                    produit.setLibelleTicket(designation.substring(0,5));
                    produit.setPrixUnit(prixUnit);
                    produit.setPrixTTC(prixTTC);
                    produit.setPrixHT( (prixTTC*100)/(100+tvaTaux) );
                    produitService.savePrdt(produit);
                }
            }
            return "Produit ajouté";
        }
        return "Produit existe déjà";
    }

    @GetMapping("/produits/{page}/{size}")
    public List<List<String>> getPageProduits(@PathVariable int page, @PathVariable int size){
        Page<Produit> produitPage = produitService.getProduits(page,size);
        List<List<String>> list = new ArrayList<>();
        produitPage.forEach(produit -> { list.add(produit.getInfo()); });
        return list;
    }

    @GetMapping("/produits/getID/{codeProduit}")
    public int getProduitIDByCodePrdt(@PathVariable String codeProduit){
        return produitService.getPrdtByCodePrdt(codeProduit).getID();
    }

    @GetMapping("/produits/getCodesPrdts")
    public List<String> getCodesPrdts(){
        List<Produit> produitsList = produitService.getListProduits();
        List<String> list = new ArrayList<>();
        for (Produit prdt:produitsList) {
            list.add(prdt.getCodePrdt());
        }
        return list;
    }

    @GetMapping("/produits/totalPages/{page}/{size}")
    public int getTotalPagesProduits(@PathVariable int page, @PathVariable int size){
        return produitService.getProduits(page,size).getTotalPages();
    }

    @GetMapping("/produits/getByFamille/{familleID}")
    public List<String> getByFamille(@PathVariable int familleID){
        Famille famille = familleService.getFamilleByID(familleID);
        List<Produit> produitsList = produitService.getProduitsByFamille(famille);
        List<String> list = new ArrayList<>();
        if(produitsList != null) {
            for (Produit prdt:produitsList) {
                list.add(prdt.getCodePrdt());
            }
        }
        else {
            list.add("Aucun produit");
        }
        return list;
    }
}
