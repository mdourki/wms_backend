package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.Depot;
import com.dourki.wms_backend.entities.Emplacement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmplacementRepository extends JpaRepository<Emplacement, Integer> {
    Emplacement findEmplacementByAlleeAndNivHorizAndNivVertiAndDepot(String allee ,
                                                                      String NivHoriz ,
                                                                      String NivVerti ,
                                                                      Depot depot);
    Emplacement findEmplacementByID(int id);
    List<Emplacement> findEmplacementsByDepot(Depot depot);
    void deleteEmplacementByID(int id);
}
