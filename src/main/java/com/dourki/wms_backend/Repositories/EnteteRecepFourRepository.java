package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.EnteteRecepFour;
import com.dourki.wms_backend.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnteteRecepFourRepository extends JpaRepository<EnteteRecepFour , Integer> {
 EnteteRecepFour findEnteteRecepFourByID(int id);
 EnteteRecepFour findEnteteRecepFourByFournisseur(Fournisseur fournisseur);
}
