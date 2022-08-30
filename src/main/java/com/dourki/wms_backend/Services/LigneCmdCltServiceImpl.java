package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.LigneCmdCltRepository;
import com.dourki.wms_backend.Repositories.LigneCmdFourRepository;
import com.dourki.wms_backend.entities.EnteteCmdClt;
import com.dourki.wms_backend.entities.EnteteCmdFour;
import com.dourki.wms_backend.entities.LigneCmdClt;
import com.dourki.wms_backend.entities.LigneCmdFour;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class LigneCmdCltServiceImpl implements LigneCmdCltService{

    LigneCmdCltRepository ligneCmdCltRepository;

    @Override
    public LigneCmdClt saveLigneCmd(LigneCmdClt ligneCmdClt) {
        return ligneCmdCltRepository.save(ligneCmdClt);
    }

    @Override
    public LigneCmdClt findLigneCmdByID(int id) {
        return ligneCmdCltRepository.findLigneCmdCltByID(id);
    }

    @Override
    public LigneCmdClt findLigneCmdByEnteteCmd(EnteteCmdClt enteteCmdClt) {
        return ligneCmdCltRepository.findLigneCmdCltByEnteteCmdClt(enteteCmdClt);
    }

    @Override
    public Page<LigneCmdClt> getPageLigneCmdClt(int page, int size) {
        return ligneCmdCltRepository.findAll(PageRequest.of(page , size));
    }
}
