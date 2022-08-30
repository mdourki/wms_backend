package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.Style;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StyleRepository extends JpaRepository<Style, Integer> {
    Style findStyleByNom(String Nom);
    Style findStyleByID(int id);
    void deleteStyleByID(int id);
}
