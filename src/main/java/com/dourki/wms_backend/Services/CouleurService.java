package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.Couleur;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CouleurService {
    Couleur saveCouleur(Couleur couleur);
    Page<Couleur> getCouleurs(int page, int size);
    List<Couleur> getListCouleurs();
    Couleur getCouleurByCode(String code);
    Couleur getCouleurByCodeAndNom(String code , String nom);
    Couleur getCouleurByNom(String nom);
    Couleur getCouleurByID(int id);
    void deleteCouleurByID(int id);
}
