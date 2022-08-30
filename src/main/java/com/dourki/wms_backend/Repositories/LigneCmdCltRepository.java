package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.EnteteCmdClt;
import com.dourki.wms_backend.entities.LigneCmdClt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCmdCltRepository extends JpaRepository<LigneCmdClt , Integer> {
    LigneCmdClt findLigneCmdCltByID(int ID);
    LigneCmdClt findLigneCmdCltByEnteteCmdClt(EnteteCmdClt enteteCmdClt);
}
