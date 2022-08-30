package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.Palette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaletteRepository extends JpaRepository<Palette, Integer> {
    Palette findPaletteByNomAndNumeroSerie(String nom , String numeroSerie );
    Palette findPaletteByID(int id);
    Palette findPaletteByNumeroSerie(String numeroSerie);
    Palette findPaletteByNom(String nom);
    void deletePaletteByID(int id);
}
