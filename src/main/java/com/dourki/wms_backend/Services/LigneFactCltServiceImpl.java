package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.LigneFactCltRepository;
import com.dourki.wms_backend.Repositories.LigneFactFourRepository;
import com.dourki.wms_backend.entities.EnteteFactClt;
import com.dourki.wms_backend.entities.EnteteFactFour;
import com.dourki.wms_backend.entities.LigneFactClt;
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
public class LigneFactCltServiceImpl implements LigneFactCltService{

    LigneFactCltRepository ligneFactCltRepository;


    @Override
    public LigneFactClt saveLigneFact(LigneFactClt ligneFactClt) {
        return ligneFactCltRepository.save(ligneFactClt);
    }

    @Override
    public LigneFactClt findLigneFactByID(int id) {
        return ligneFactCltRepository.findLigneFactCltByID(id);
    }

    @Override
    public LigneFactClt findLigneFactByEnteteFact(EnteteFactClt enteteFactClt) {
        return ligneFactCltRepository.findLigneFactCltByEnteteFactClt(enteteFactClt);
    }

    @Override
    public List<LigneFactClt> getListLigneFactClt() {
        return ligneFactCltRepository.findAll();
    }

    @Override
    public Page<LigneFactClt> getPageLigneFactClt(int page, int size) {
        return ligneFactCltRepository.findAll(PageRequest.of(page, size));
    }
}
