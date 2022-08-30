package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.EnteteCmdFourRepository;
import com.dourki.wms_backend.Repositories.LigneCmdFourRepository;
import com.dourki.wms_backend.entities.EnteteCmdFour;
import com.dourki.wms_backend.entities.Fournisseur;
import com.dourki.wms_backend.entities.LigneCmdFour;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class LigneCmdFourServiceImpl implements LigneCmdFourService{

    LigneCmdFourRepository ligneCmdFourRepository;

    @Override
    public LigneCmdFour saveLigneCmd(LigneCmdFour ligneCmdFour) {
        return ligneCmdFourRepository.save(ligneCmdFour);
    }

    @Override
    public LigneCmdFour findLigneCmdByID(int id) {
        return ligneCmdFourRepository.findLigneCmdFourByID(id);
    }

    @Override
    public LigneCmdFour findLigneCmdByEnteteCmd(EnteteCmdFour enteteCmdFour) {
        return ligneCmdFourRepository.findLigneCmdFourByEnteteCmdFour(enteteCmdFour);
    }
}
