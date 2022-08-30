package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.EnteteFactClt;
import com.dourki.wms_backend.entities.LigneFactClt;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LigneFactCltService {
    LigneFactClt saveLigneFact(LigneFactClt ligneFactClt);
    LigneFactClt findLigneFactByID(int id);
    LigneFactClt findLigneFactByEnteteFact(EnteteFactClt enteteFactClt);
    List<LigneFactClt> getListLigneFactClt();
    Page<LigneFactClt> getPageLigneFactClt(int page , int size);
}
