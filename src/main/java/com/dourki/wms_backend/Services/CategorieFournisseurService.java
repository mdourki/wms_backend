package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.CategorieFournisseur;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategorieFournisseurService {
    CategorieFournisseur saveCategorie(CategorieFournisseur categorieFournisseur);
    Page<CategorieFournisseur> getCategories(int page, int size);
    List<CategorieFournisseur> getListCategories();
    CategorieFournisseur getCategorieByNom(String Nom);
    CategorieFournisseur getCategorieByID(int id);
    void deleteCategorieByID(int id);
}
