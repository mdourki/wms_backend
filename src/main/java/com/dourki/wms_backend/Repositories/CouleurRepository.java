package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.Couleur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouleurRepository extends JpaRepository<Couleur, Integer> {
    Couleur findCouleurByCodeClrAndNom(String codeCouleur , String nom);
    Couleur findCouleurByNom(String nom);
    Couleur findCouleurByCodeClr(String codeCouleur);
    Couleur findCouleurByID(int id);
    void deleteCouleurByID(int id);
}
