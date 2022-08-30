package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
    Fournisseur findFournisseurByNomAndAdresseAndNumTelAndEmail(String nom,String adresse, String numTel, String email);
    Fournisseur findFournisseurByID(int id);
    Fournisseur findFournisseurByNom(String nom);
    void deleteFournisseurByID(int id);
}
