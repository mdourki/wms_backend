package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.FamilleRepository;
import com.dourki.wms_backend.entities.Famille;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class FamilleServiceImpl implements FamilleService{

    private FamilleRepository familleRepository;

    @Override
    public Famille saveFamille(Famille famille) {
        familleRepository.save(famille);
        return famille;
    }

    @Override
    public Page<Famille> getFamilles(int page, int size) {
        Page<Famille> famillePage = familleRepository.findAll(PageRequest.of(page, size));
        return famillePage;
    }

    @Override
    public List<Famille> getListFamilles() {
        return familleRepository.findAll();
    }

    @Override
    public Famille getFamilleByNom(String Nom) {
        return familleRepository.findFamilleByNom(Nom);
    }

    @Override
    public Famille getFamilleByID(int id) {
        return familleRepository.findFamilleByID(id);
    }

    @Override
    public void deleteFamilleByID(int id) {
        familleRepository.deleteFamilleByID(id);
    }
}
