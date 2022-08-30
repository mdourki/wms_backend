package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.Fournisseur;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FournisseurService {
    Fournisseur saveFournisseur(Fournisseur fournisseur);
    Page<Fournisseur> getFournisseurs(int page, int size);
    List<Fournisseur> getListFournisseurs();
    Fournisseur getFournisseurByID(int id);
    Fournisseur getFournisseurByNom(String fournisseurName);
    Fournisseur getFournisseurByNomAndAdresseAndNumTelAndEmail(String nom,String adresse, String numTel, String email);
    void deleteFournisseurByID(int id);
}
