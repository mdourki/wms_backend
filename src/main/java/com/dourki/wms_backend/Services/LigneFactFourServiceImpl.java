package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.LigneFactFourRepository;
import com.dourki.wms_backend.entities.EnteteFactFour;
import com.dourki.wms_backend.entities.LigneFactFour;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class LigneFactFourServiceImpl implements LigneFactFourService{

    LigneFactFourRepository ligneFactFourRepository;

    @Override
    public LigneFactFour saveLigneFact(LigneFactFour ligneFactFour) {
        return ligneFactFourRepository.save(ligneFactFour);
    }

    @Override
    public LigneFactFour findLigneFactByID(int id) {
        return ligneFactFourRepository.findLigneFactFourByID(id);
    }

    @Override
    public LigneFactFour findLigneFactByEnteteFact(EnteteFactFour enteteFactFour) {
        return ligneFactFourRepository.findLigneFactFourByEnteteFactFour(enteteFactFour);
    }

    @Override
    public List<LigneFactFour> getListLigneFactFour() {
        return ligneFactFourRepository.findAll();
    }

    @Override
    public Page<LigneFactFour> getPageLigneFactFour(int page, int size) {
        return ligneFactFourRepository.findAll(PageRequest.of(page, size));
    }
}
