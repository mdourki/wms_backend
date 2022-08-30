package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.CategorieClient;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategorieClientService {
    CategorieClient saveCategorie(CategorieClient categorieClient);
    Page<CategorieClient> getCategories(int page, int size);
    List<CategorieClient> getListCategories();
    CategorieClient getCategorieByNom(String Nom);
    CategorieClient getCategorieByID(int id);
    void deleteCategorieByNom(String Nom);
    void deleteCategorieByID(int id);
}
