package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.EnteteCmdFour;
import com.dourki.wms_backend.entities.LigneCmdFour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCmdFourRepository extends JpaRepository<LigneCmdFour , Integer> {
    LigneCmdFour findLigneCmdFourByID(int ID);
    LigneCmdFour findLigneCmdFourByEnteteCmdFour(EnteteCmdFour enteteCmdFour);
}
