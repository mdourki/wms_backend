package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.CategorieClient;
import com.dourki.wms_backend.entities.CategorieFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieFournisseurRepository extends JpaRepository<CategorieFournisseur, Integer> {
    CategorieFournisseur findCategorieFournisseurByNom(String Nom);
    CategorieFournisseur findCategorieFournisseurByID(int id);
    void deleteCategorieClientByID(int id);
}
