package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.StyleRepository;
import com.dourki.wms_backend.entities.Style;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class StyleServiceImpl implements StyleService{

    private StyleRepository styleRepository;

    @Override
    public Style saveStyle(Style style) {
        return styleRepository.save(style);
    }

    @Override
    public Page<Style> getStyles(int page, int size) {
        Page<Style> stylePage = styleRepository.findAll(PageRequest.of(page, size));
        return stylePage;
    }

    @Override
    public List<Style> getListStyles() {
        return styleRepository.findAll();
    }

    @Override
    public Style getStyleByNom(String Nom) {
        return styleRepository.findStyleByNom(Nom);
    }

    @Override
    public Style getStyleByID(int id) {
        return styleRepository.findStyleByID(id);
    }

    @Override
    public void deleteStyleByID(int id) {
        styleRepository.deleteStyleByID(id);
    }
}
