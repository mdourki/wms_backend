package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.Famille;
import com.dourki.wms_backend.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit , Integer> {
    Produit getProduitByCodeBarre(String code_barre);
    Produit getProduitByCodePrdt(String code_prdt);
    List<Produit> findProduitsByFamille(Famille famille);
    List<Produit> findProduitsByNom(String nom);
}
