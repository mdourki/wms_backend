package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.LigneRecepFour;
import com.dourki.wms_backend.entities.EnteteRecepFour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneRecepFourRepository extends JpaRepository<LigneRecepFour , Integer> {
    LigneRecepFour findLigneRecepFourByID(int ID);
    LigneRecepFour findLigneRecepFourByEnteteRecepFour(EnteteRecepFour enteteRecepFour);
}
