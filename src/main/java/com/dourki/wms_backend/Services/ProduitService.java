package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.Famille;
import com.dourki.wms_backend.entities.Produit;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProduitService {
    Produit getPrdt(String code_barre);
    Produit getPrdtByCodePrdt(String codePrdt);
    List<Produit> getPrdtsByNom(String nom);
    Page<Produit> getProduits(int page, int size);
    List<Produit> getListProduits();
    List<Produit> getProduitsByFamille(Famille famille);
    Produit savePrdt(Produit prdt);
}
