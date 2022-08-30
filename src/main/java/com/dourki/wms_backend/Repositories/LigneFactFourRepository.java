package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.EnteteFactFour;
import com.dourki.wms_backend.entities.LigneFactFour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneFactFourRepository extends JpaRepository<LigneFactFour , Integer> {
    LigneFactFour findLigneFactFourByID(int ID);
    LigneFactFour findLigneFactFourByEnteteFactFour(EnteteFactFour enteteFactFour);
}
