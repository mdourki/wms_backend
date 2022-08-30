package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.LigneRecepFourRepository;
import com.dourki.wms_backend.entities.EnteteRecepFour;
import com.dourki.wms_backend.entities.LigneRecepFour;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class LigneRecepFourServiceImpl implements LigneRecepFourService{

    LigneRecepFourRepository ligneRecepFourRepository;

    @Override
    public LigneRecepFour saveLigneRecep(LigneRecepFour ligneRecepFour) {
        return ligneRecepFourRepository.save(ligneRecepFour);
    }

    @Override
    public LigneRecepFour findLigneRecepByID(int id) {
        return ligneRecepFourRepository.findLigneRecepFourByID(id);
    }

    @Override
    public LigneRecepFour findLigneRecepByEnteteRecep(EnteteRecepFour enteteRecepFour) {
        return ligneRecepFourRepository.findLigneRecepFourByEnteteRecepFour(enteteRecepFour);
    }
}
