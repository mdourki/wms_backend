package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.EmplacementRepository;
import com.dourki.wms_backend.entities.Depot;
import com.dourki.wms_backend.entities.Emplacement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class EmplacementServiceImpl implements EmplacementService{

    private EmplacementRepository emplacementRepository;

    @Override
    public Emplacement saveEmplacement(Emplacement emplacement) {
        return emplacementRepository.save(emplacement);
    }

    @Override
    public Page<Emplacement> getEmplacements(int page, int size) {
        return emplacementRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Emplacement> getListEmplacements() {
        return emplacementRepository.findAll();
    }

    @Override
    public List<Emplacement> getEmplacementsByDepot(Depot depot) {
        return emplacementRepository.findEmplacementsByDepot(depot);
    }

    @Override
    public Emplacement getEmplacementByID(int id) {
        return emplacementRepository.findEmplacementByID(id);
    }

    @Override
    public Emplacement getEmplacementByAlleeAndNivHorizAndNivVertiAndDepot(String allee,
                                                                   String nivHoriz,
                                                                   String nivVerti,
                                                                   Depot depot) {
        return emplacementRepository.
                findEmplacementByAlleeAndNivHorizAndNivVertiAndDepot(allee , nivHoriz , nivHoriz , depot);
    }

    @Override
    public void deleteEmplacementByID(int id) {
        emplacementRepository.deleteEmplacementByID(id);
    }
}
