package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.Palette;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PaletteService {
    Palette savePalette(Palette palette);
    Page<Palette> getPalettes(int page, int size);
    List<Palette> getListPalettes();
    Palette getPaletteByID(int id);
    Palette getPaletteByNumeroSerie(String numeroSerie);
    Palette getPaletteByNom(String nom);
    Palette getPaletteByNomAndNumeroSerie(String nom , String numeroSerie );
    void deletePaletteByID(int id);
}
