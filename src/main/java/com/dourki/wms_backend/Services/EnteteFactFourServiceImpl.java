package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.EnteteFactFourRepository;
import com.dourki.wms_backend.entities.EnteteFactFour;
import com.dourki.wms_backend.entities.Fournisseur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class EnteteFactFourServiceImpl implements EnteteFactFourService{

    EnteteFactFourRepository enteteFactFourRepository;

    @Override
    public EnteteFactFour saveEnteteFact(EnteteFactFour enteteFactFour) {
        return enteteFactFourRepository.save(enteteFactFour);
    }

    @Override
    public EnteteFactFour findEnteteFactByID(int id) {
        return enteteFactFourRepository.findEnteteFactFourByID(id);
    }

    @Override
    public EnteteFactFour findEnteteFactByFournisseur(Fournisseur fournisseur) {
        return enteteFactFourRepository.findEnteteFactFourByFournisseur(fournisseur);
    }
}
