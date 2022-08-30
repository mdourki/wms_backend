package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.EnteteLivClt;
import com.dourki.wms_backend.entities.LigneLivClt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneLivCltRepository extends JpaRepository<LigneLivClt , Integer> {
    LigneLivClt findLigneLivCltByID(int ID);
    LigneLivClt findLigneLivCltByEnteteLivClt(EnteteLivClt enteteLivClt);
}
