package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.PaletteRepository;
import com.dourki.wms_backend.entities.Palette;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PaletteServiceImpl implements PaletteService{

    private PaletteRepository paletteRepository;

    @Override
    public Palette savePalette(Palette palette) {
        return paletteRepository.save(palette);
    }

    @Override
    public Page<Palette> getPalettes(int page, int size) {
        return paletteRepository.findAll(PageRequest.of(page , size));
    }

    @Override
    public List<Palette> getListPalettes() {
        return paletteRepository.findAll();
    }

    @Override
    public Palette getPaletteByID(int id) {
        return paletteRepository.findPaletteByID(id);
    }

    @Override
    public Palette getPaletteByNumeroSerie(String numeroSerie) {
        return paletteRepository.findPaletteByNumeroSerie(numeroSerie);
    }

    @Override
    public Palette getPaletteByNom(String nom) {
        return paletteRepository.findPaletteByNom(nom);
    }

    @Override
    public Palette getPaletteByNomAndNumeroSerie(String nom, String numeroSerie) {
        return paletteRepository.findPaletteByNomAndNumeroSerie(nom , numeroSerie);
    }

    @Override
    public void deletePaletteByID(int id) {
        paletteRepository.deletePaletteByID(id);
    }
}
