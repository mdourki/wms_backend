package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.CategorieClientRepository;
import com.dourki.wms_backend.entities.CategorieClient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CategorieClientServiceImpl implements CategorieClientService {
    private CategorieClientRepository categorieClientRepository;


    @Override
    public CategorieClient saveCategorie(CategorieClient categorieClient) {
        categorieClientRepository.save(categorieClient);
        return categorieClient;
    }

    @Override
    public Page<CategorieClient> getCategories(int page, int size) {
        Page<CategorieClient> categorieClientPage = categorieClientRepository.findAll(PageRequest.of(page, size));
        return categorieClientPage;
    }

    @Override
    public List<CategorieClient> getListCategories() {
        return categorieClientRepository.findAll();
    }

    @Override
    public CategorieClient getCategorieByNom(String Nom) {
        return categorieClientRepository.findCategorieClientByNom(Nom);
    }

    @Override
    public CategorieClient getCategorieByID(int id) {
        return categorieClientRepository.findCategorieClientByID(id);
    }

    @Override
    public void deleteCategorieByNom(String Nom) {
        categorieClientRepository.deleteCategorieClientByNom(Nom);
    }

    @Override
    public void deleteCategorieByID(int id) {
        categorieClientRepository.deleteCategorieClientByID(id);
    }
}
