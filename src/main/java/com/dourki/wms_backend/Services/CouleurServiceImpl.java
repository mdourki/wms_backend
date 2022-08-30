package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.CouleurRepository;
import com.dourki.wms_backend.entities.Couleur;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CouleurServiceImpl implements CouleurService{

    private CouleurRepository couleurRepository;

    @Override
    public Couleur saveCouleur(Couleur couleur) {
        return couleurRepository.save(couleur);
    }

    @Override
    public Page<Couleur> getCouleurs(int page, int size) {
        return couleurRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Couleur> getListCouleurs() {
        return couleurRepository.findAll();
    }

    @Override
    public Couleur getCouleurByCode(String code) {
        return couleurRepository.findCouleurByCodeClr(code);
    }

    @Override
    public Couleur getCouleurByCodeAndNom(String code , String nom) {
        return couleurRepository.findCouleurByCodeClrAndNom(code,nom);
    }

    @Override
    public Couleur getCouleurByNom(String nom) {
        return couleurRepository.findCouleurByNom(nom);
    }

    @Override
    public Couleur getCouleurByID(int id) {
        return couleurRepository.findCouleurByID(id);
    }

    @Override
    public void deleteCouleurByID(int id) {
        couleurRepository.deleteCouleurByID(id);
    }
}
