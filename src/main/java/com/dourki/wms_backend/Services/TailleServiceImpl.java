package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.TailleRepository;
import com.dourki.wms_backend.entities.Taille;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TailleServiceImpl implements TailleService{

    private TailleRepository tailleRepository;

    @Override
    public Taille saveTaille(Taille taille) {
        return tailleRepository.save(taille);
    }

    @Override
    public Page<Taille> getTailles(int page, int size) {
        return tailleRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Taille> getListTailles() {
        return tailleRepository.findAll();
    }

    @Override
    public Taille getTailleByCode(String code) {
        return tailleRepository.findTailleByCodeTaille(code);
    }

    @Override
    public Taille getTailleByCodeAndNom(String code, String nom) {
        return tailleRepository.findTailleByCodeTailleAndNom(code , nom);
    }

    @Override
    public Taille getTailleByNom(String nom) {
        return tailleRepository.findTailleByNom(nom);
    }

    @Override
    public Taille getTailleByID(int id) {
        return tailleRepository.findTailleByID(id);
    }

    @Override
    public void deleteTailleByID(int id) {
        tailleRepository.deleteTailleByID(id);
    }
}
