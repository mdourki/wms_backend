package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.EnteteRecepFourRepository;
import com.dourki.wms_backend.entities.EnteteRecepFour;
import com.dourki.wms_backend.entities.Fournisseur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class EnteteRecepFourServiceImpl implements EnteteRecepFourService{

    EnteteRecepFourRepository enteteRecepFourRepository;

    @Override
    public EnteteRecepFour saveEnteteRecep(EnteteRecepFour enteteRecepFour) {
        return enteteRecepFourRepository.save(enteteRecepFour);
    }

    @Override
    public EnteteRecepFour findEnteteRecepByID(int id) {
        return enteteRecepFourRepository.findEnteteRecepFourByID(id);
    }

    @Override
    public EnteteRecepFour findEnteteRecepByFournisseur(Fournisseur fournisseur) {
        return enteteRecepFourRepository.findEnteteRecepFourByFournisseur(fournisseur);
    }
}
