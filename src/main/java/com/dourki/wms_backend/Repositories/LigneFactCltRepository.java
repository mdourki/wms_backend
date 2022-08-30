package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.EnteteFactClt;
import com.dourki.wms_backend.entities.LigneFactClt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneFactCltRepository extends JpaRepository<LigneFactClt , Integer> {
    LigneFactClt findLigneFactCltByID(int ID);
    LigneFactClt findLigneFactCltByEnteteFactClt(EnteteFactClt enteteFactClt);
}
