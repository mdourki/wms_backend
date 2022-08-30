package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.EnteteLivCltRepository;
import com.dourki.wms_backend.Repositories.EnteteRecepFourRepository;
import com.dourki.wms_backend.entities.Client;
import com.dourki.wms_backend.entities.EnteteLivClt;
import com.dourki.wms_backend.entities.EnteteRecepFour;
import com.dourki.wms_backend.entities.Fournisseur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class EnteteLivCltServiceImpl implements EnteteLivCltService{

    EnteteLivCltRepository enteteLivCltRepository;

    @Override
    public EnteteLivClt saveEnteteLiv(EnteteLivClt enteteLivClt) {
        return enteteLivCltRepository.save(enteteLivClt);
    }

    @Override
    public EnteteLivClt findEnteteLivByID(int id) {
        return enteteLivCltRepository.findEnteteLivCltByID(id);
    }

    @Override
    public EnteteLivClt findEnteteLivByClient(Client client) {
        return enteteLivCltRepository.findEnteteLivCltByClient(client);
    }
}
