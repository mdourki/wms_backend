package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.EnteteCmdFour;
import com.dourki.wms_backend.entities.Fournisseur;

public interface EnteteCmdFourService {
    EnteteCmdFour saveEnteteCmd(EnteteCmdFour enteteCmdFour);
    EnteteCmdFour findEnteteCmdByID(int id);
    EnteteCmdFour findEnteteCmdByFournisseur(Fournisseur fournisseur);
}
