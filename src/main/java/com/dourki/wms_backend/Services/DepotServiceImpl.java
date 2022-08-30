package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.DepotRepository;
import com.dourki.wms_backend.entities.Depot;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DepotServiceImpl implements DepotService{

    private DepotRepository depotRepository;

    @Override
    public Depot saveDepot(Depot depot) {
        return depotRepository.save(depot);
    }

    @Override
    public Page<Depot> getDepots(int page, int size) {
        return depotRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Depot> getListDepots() {
        return depotRepository.findAll();
    }

    @Override
    public Depot getDepotByLibelle(String libelle) {
        return depotRepository.findDepotByLibelle(libelle);
    }

    @Override
    public Depot getDepotByID(int id) {
        return depotRepository.findDepotByID(id);
    }

    @Override
    public void deleteDepotByID(int id) {
        depotRepository.deleteDepotByID(id);
    }
}
