package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.EnteteCmdFourRepository;
import com.dourki.wms_backend.entities.EnteteCmdFour;
import com.dourki.wms_backend.entities.Fournisseur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class EnteteCmdFourServiceImpl implements EnteteCmdFourService{

    EnteteCmdFourRepository enteteCmdFourRepository;

    @Override
    public EnteteCmdFour saveEnteteCmd(EnteteCmdFour enteteCmdFour) {
        return enteteCmdFourRepository.save(enteteCmdFour);
    }

    @Override
    public EnteteCmdFour findEnteteCmdByID(int id) {
        return enteteCmdFourRepository.findEnteteCmdFourByID(id);
    }

    @Override
    public EnteteCmdFour findEnteteCmdByFournisseur(Fournisseur fournisseur) {
        return enteteCmdFourRepository.findEnteteCmdFourByFournisseur(fournisseur);
    }
}
