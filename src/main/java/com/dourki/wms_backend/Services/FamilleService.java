package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.Famille;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FamilleService {
    Famille saveFamille(Famille famille);
    Page<Famille> getFamilles(int page, int size);
    List<Famille> getListFamilles();
    Famille getFamilleByNom(String Nom);
    Famille getFamilleByID(int id);
    void deleteFamilleByID(int id);
}
