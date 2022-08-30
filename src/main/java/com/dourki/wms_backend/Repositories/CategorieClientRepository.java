package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.CategorieClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieClientRepository extends JpaRepository<CategorieClient , Integer> {
    CategorieClient findCategorieClientByNom(String Nom);
    CategorieClient findCategorieClientByID(int id);
    void deleteCategorieClientByNom(String Nom);
    void deleteCategorieClientByID(int id);
}
