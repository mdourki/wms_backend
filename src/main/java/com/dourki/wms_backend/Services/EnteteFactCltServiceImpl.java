package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.EnteteFactCltRepository;
import com.dourki.wms_backend.Repositories.EnteteFactFourRepository;
import com.dourki.wms_backend.entities.Client;
import com.dourki.wms_backend.entities.EnteteFactClt;
import com.dourki.wms_backend.entities.EnteteFactFour;
import com.dourki.wms_backend.entities.Fournisseur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class EnteteFactCltServiceImpl implements EnteteFactCltService{

    EnteteFactCltRepository enteteFactCltRepository;

    @Override
    public EnteteFactClt saveEnteteFact(EnteteFactClt enteteFactClt) {
        return enteteFactCltRepository.save(enteteFactClt);
    }

    @Override
    public EnteteFactClt findEnteteFactByID(int id) {
        return enteteFactCltRepository.findEnteteFactCltByID(id);
    }

    @Override
    public EnteteFactClt findEnteteFactByClient(Client client) {
        return enteteFactCltRepository.findEnteteFactCltByClient(client);
    }

}
