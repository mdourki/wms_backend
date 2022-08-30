package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.TVA;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TvaService {
    TVA saveTva(TVA tva);
    Page<TVA> getTVAs(int page, int size);
    List<TVA> getListTVA();
    TVA getTvaByTaux(float taux);
    TVA getTvaByID(int id);
    void deleteTvaByID(int id);
}
