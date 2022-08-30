package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.EnteteCmdClt;
import com.dourki.wms_backend.entities.LigneCmdClt;
import com.dourki.wms_backend.entities.LigneFactClt;
import org.springframework.data.domain.Page;

public interface LigneCmdCltService {
    LigneCmdClt saveLigneCmd(LigneCmdClt ligneCmdClt);
    LigneCmdClt findLigneCmdByID(int id);
    LigneCmdClt findLigneCmdByEnteteCmd(EnteteCmdClt enteteCmdClt);
    Page<LigneCmdClt> getPageLigneCmdClt(int page , int size);
}
