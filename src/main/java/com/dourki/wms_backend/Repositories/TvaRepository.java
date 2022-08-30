package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.TVA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TvaRepository extends JpaRepository<TVA, Integer> {
    TVA findTVAByTaux(float taux);
    TVA findTVAByID(int id);
    void deleteTVAByID(int id);
}
