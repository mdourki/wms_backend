package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.Depot;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DepotService {
    Depot saveDepot(Depot depot);
    Page<Depot> getDepots(int page, int size);
    List<Depot> getListDepots();
    Depot getDepotByLibelle(String libelle);
    Depot getDepotByID(int id);
    void deleteDepotByID(int id);
}
