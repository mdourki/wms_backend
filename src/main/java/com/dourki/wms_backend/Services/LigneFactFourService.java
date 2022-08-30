package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.EnteteFactFour;
import com.dourki.wms_backend.entities.LigneFactFour;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LigneFactFourService {
    LigneFactFour saveLigneFact(LigneFactFour ligneFactFour);
    LigneFactFour findLigneFactByID(int id);
    LigneFactFour findLigneFactByEnteteFact(EnteteFactFour enteteFactFour);
    List<LigneFactFour> getListLigneFactFour();
    Page<LigneFactFour> getPageLigneFactFour(int page , int size);
}
