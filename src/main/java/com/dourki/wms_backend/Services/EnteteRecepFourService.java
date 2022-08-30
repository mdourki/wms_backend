package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.EnteteRecepFour;
import com.dourki.wms_backend.entities.Fournisseur;

public interface EnteteRecepFourService {
    EnteteRecepFour saveEnteteRecep(EnteteRecepFour enteteRecepFour);
    EnteteRecepFour findEnteteRecepByID(int id);
    EnteteRecepFour findEnteteRecepByFournisseur(Fournisseur fournisseur);
}
