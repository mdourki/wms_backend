package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.Collection;
import com.dourki.wms_backend.entities.Famille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<Collection, Integer> {
    Collection findCollectionByNom(String Nom);
    Collection findCollectionByID(int id);
    void deleteCollectionByID(int id);
}
