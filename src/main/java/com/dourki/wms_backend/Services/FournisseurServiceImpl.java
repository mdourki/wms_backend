package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.FournisseurRepository;
import com.dourki.wms_backend.entities.Fournisseur;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class FournisseurServiceImpl implements FournisseurService{

    private FournisseurRepository fournisseurRepository;

    @Override
    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Page<Fournisseur> getFournisseurs(int page, int size) {
        return fournisseurRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Fournisseur> getListFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur getFournisseurByID(int id) {
        return fournisseurRepository.findFournisseurByID(id);
    }

    @Override
    public Fournisseur getFournisseurByNom(String fournisseurName) {
        return fournisseurRepository.findFournisseurByNom(fournisseurName);
    }

    @Override
    public Fournisseur getFournisseurByNomAndAdresseAndNumTelAndEmail(String nom, String adresse, String numTel, String email) {
        return fournisseurRepository.findFournisseurByNomAndAdresseAndNumTelAndEmail(nom , adresse , numTel , email);
    }

    @Override
    public void deleteFournisseurByID(int id) {
        fournisseurRepository.deleteFournisseurByID(id);
    }
}
