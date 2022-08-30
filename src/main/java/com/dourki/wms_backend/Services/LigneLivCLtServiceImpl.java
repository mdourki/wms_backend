package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.LigneLivCltRepository;
import com.dourki.wms_backend.Repositories.LigneRecepFourRepository;
import com.dourki.wms_backend.entities.EnteteLivClt;
import com.dourki.wms_backend.entities.EnteteRecepFour;
import com.dourki.wms_backend.entities.LigneLivClt;
import com.dourki.wms_backend.entities.LigneRecepFour;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class LigneLivCLtServiceImpl implements LigneLivCltService{

    LigneLivCltRepository ligneLivCltRepository;


    @Override
    public LigneLivClt saveLigneRecep(LigneLivClt ligneLivClt) {
        return ligneLivCltRepository.save(ligneLivClt);
    }

    @Override
    public LigneLivClt findLigneRecepByID(int id) {
        return ligneLivCltRepository.findLigneLivCltByID(id);
    }

    @Override
    public LigneLivClt findLigneRecepByEnteteLiv(EnteteLivClt enteteLivClt) {
        return ligneLivCltRepository.findLigneLivCltByEnteteLivClt(enteteLivClt);
    }
}
