package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.CategorieClient;
import com.dourki.wms_backend.entities.Famille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilleRepository extends JpaRepository<Famille, Integer> {
    Famille findFamilleByNom(String Nom);
    Famille findFamilleByID(int id);
    void deleteFamilleByID(int id);
}
