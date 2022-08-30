package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.EnteteFactFour;
import com.dourki.wms_backend.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnteteFactFourRepository extends JpaRepository<EnteteFactFour , Integer> {
 EnteteFactFour findEnteteFactFourByID(int id);
 EnteteFactFour findEnteteFactFourByFournisseur(Fournisseur fournisseur);
}
