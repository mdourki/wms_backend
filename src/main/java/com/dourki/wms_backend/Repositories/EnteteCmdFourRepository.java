package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.EnteteCmdFour;
import com.dourki.wms_backend.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnteteCmdFourRepository extends JpaRepository<EnteteCmdFour , Integer> {
 EnteteCmdFour findEnteteCmdFourByID(int id);
 EnteteCmdFour findEnteteCmdFourByFournisseur(Fournisseur fournisseur);
}
