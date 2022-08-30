package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.EnteteCmdFour;
import com.dourki.wms_backend.entities.LigneCmdFour;
import com.dourki.wms_backend.entities.Fournisseur;

public interface LigneCmdFourService {
    LigneCmdFour saveLigneCmd(LigneCmdFour ligneCmdFour);
    LigneCmdFour findLigneCmdByID(int id);
    LigneCmdFour findLigneCmdByEnteteCmd(EnteteCmdFour enteteCmdFour);
}
