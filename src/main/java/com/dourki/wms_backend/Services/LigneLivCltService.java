package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.EnteteLivClt;
import com.dourki.wms_backend.entities.LigneLivClt;

public interface LigneLivCltService {
    LigneLivClt saveLigneRecep(LigneLivClt ligneLivClt);
    LigneLivClt findLigneRecepByID(int id);
    LigneLivClt findLigneRecepByEnteteLiv(EnteteLivClt enteteLivClt);
}
