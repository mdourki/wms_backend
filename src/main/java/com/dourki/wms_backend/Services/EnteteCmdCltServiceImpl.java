package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.EnteteCmdCltRepository;
import com.dourki.wms_backend.entities.Client;
import com.dourki.wms_backend.entities.EnteteCmdClt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class EnteteCmdCltServiceImpl implements EnteteCmdCltService{

    EnteteCmdCltRepository enteteCmdCltRepository;

    @Override
    public EnteteCmdClt saveEnteteCmd(EnteteCmdClt enteteCmdClt) {
        return enteteCmdCltRepository.save(enteteCmdClt);
    }

    @Override
    public EnteteCmdClt findEnteteCmdByID(int id) {
        return enteteCmdCltRepository.findEnteteCmdCltByID(id);
    }

    @Override
    public EnteteCmdClt findEnteteCmdByClient(Client client) {
        return enteteCmdCltRepository.findEnteteCmdCltByClient(client);
    }

}
