package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.Style;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StyleService {
    Style saveStyle(Style style);
    Page<Style> getStyles(int page, int size);
    List<Style> getListStyles();
    Style getStyleByNom(String Nom);
    Style getStyleByID(int id);
    void deleteStyleByID(int id);
}
