package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.Taille;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TailleService {
    Taille saveTaille(Taille taille);
    Page<Taille> getTailles(int page, int size);
    List<Taille> getListTailles();
    Taille getTailleByCode(String code);
    Taille getTailleByCodeAndNom(String code , String nom);
    Taille getTailleByNom(String nom);
    Taille getTailleByID(int id);
    void deleteTailleByID(int id);
}
