package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.ProduitRepository;
import com.dourki.wms_backend.entities.Famille;
import com.dourki.wms_backend.entities.Produit;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService{

    private ProduitRepository produitRepository;

    @Override
    public Produit getPrdt(String code_barre) {
        Produit produit = produitRepository.getProduitByCodeBarre(code_barre);
        return produit;
    }

    @Override
    public Produit getPrdtByCodePrdt(String codePrdt) {
        return produitRepository.getProduitByCodePrdt(codePrdt);
    }

    @Override
    public List<Produit> getPrdtsByNom(String nom) {
        return produitRepository.findProduitsByNom(nom);
    }

    @Override
    public Page<Produit> getProduits(int page, int size) {
        return produitRepository.findAll(PageRequest.of(page , size));
    }

    @Override
    public List<Produit> getListProduits() {
        return produitRepository.findAll();
    }

    @Override
    public List<Produit> getProduitsByFamille(Famille famille) {
        return produitRepository.findProduitsByFamille(famille);
    }

    @Override
    public Produit savePrdt(Produit prdt) {
        return produitRepository.save(prdt);
    }
}
