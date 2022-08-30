package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.Depot;
import com.dourki.wms_backend.entities.Emplacement;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmplacementService {
    Emplacement saveEmplacement(Emplacement emplacement);
    Page<Emplacement> getEmplacements(int page, int size);
    List<Emplacement> getListEmplacements();
    List<Emplacement> getEmplacementsByDepot(Depot depot);
    Emplacement getEmplacementByID(int id);
    Emplacement getEmplacementByAlleeAndNivHorizAndNivVertiAndDepot(String allee ,
                                                                    String nivHoriz ,
                                                                    String nivVerti ,
                                                                    Depot depot);
    void deleteEmplacementByID(int id);
}
