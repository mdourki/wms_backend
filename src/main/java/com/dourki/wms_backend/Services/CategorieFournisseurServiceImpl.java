package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.CategorieFournisseurRepository;
import com.dourki.wms_backend.entities.CategorieClient;
import com.dourki.wms_backend.entities.CategorieFournisseur;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CategorieFournisseurServiceImpl implements CategorieFournisseurService {

    private CategorieFournisseurRepository categorieFournisseurRepository;


    @Override
    public CategorieFournisseur saveCategorie(CategorieFournisseur categorieFournisseur) {
        categorieFournisseurRepository.save(categorieFournisseur);
        return categorieFournisseur;
    }

    @Override
    public Page<CategorieFournisseur> getCategories(int page, int size) {
        Page<CategorieFournisseur> categorieFournisseurPage = categorieFournisseurRepository.findAll(PageRequest.of(page, size));
        return categorieFournisseurPage;
    }

    @Override
    public List<CategorieFournisseur> getListCategories() {
        return categorieFournisseurRepository.findAll();
    }

    @Override
    public CategorieFournisseur getCategorieByNom(String Nom) {
        return categorieFournisseurRepository.findCategorieFournisseurByNom(Nom);
    }

    @Override
    public CategorieFournisseur getCategorieByID(int id) {
        return categorieFournisseurRepository.findCategorieFournisseurByID(id);
    }

    @Override
    public void deleteCategorieByID(int id) {
        categorieFournisseurRepository.deleteCategorieClientByID(id);
    }
}
