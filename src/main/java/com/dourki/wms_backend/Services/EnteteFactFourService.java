package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.EnteteFactFour;
import com.dourki.wms_backend.entities.Fournisseur;

public interface EnteteFactFourService {
    EnteteFactFour saveEnteteFact(EnteteFactFour enteteFactFour);
    EnteteFactFour findEnteteFactByID(int id);
    EnteteFactFour findEnteteFactByFournisseur(Fournisseur fournisseur);
}
