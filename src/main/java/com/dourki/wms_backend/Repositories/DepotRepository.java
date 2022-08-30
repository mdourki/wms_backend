package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.Depot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepotRepository extends JpaRepository<Depot, Integer> {
    Depot findDepotByLibelle(String libelle);
    Depot findDepotByID(int id);
    void deleteDepotByID(int id);
}
