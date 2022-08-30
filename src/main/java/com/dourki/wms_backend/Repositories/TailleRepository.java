package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.Taille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TailleRepository extends JpaRepository<Taille, Integer> {
    Taille findTailleByCodeTaille(String codeTaille);
    Taille findTailleByCodeTailleAndNom(String codeTaille , String nom);
    Taille findTailleByNom(String nom);
    Taille findTailleByID(int id);
    void deleteTailleByID(int id);
}
