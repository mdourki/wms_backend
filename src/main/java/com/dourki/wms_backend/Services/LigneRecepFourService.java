package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.EnteteRecepFour;
import com.dourki.wms_backend.entities.LigneRecepFour;

public interface LigneRecepFourService {
    LigneRecepFour saveLigneRecep(LigneRecepFour ligneRecepFour);
    LigneRecepFour findLigneRecepByID(int id);
    LigneRecepFour findLigneRecepByEnteteRecep(EnteteRecepFour enteteRecepFour);
}
