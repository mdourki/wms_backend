package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.TvaRepository;
import com.dourki.wms_backend.entities.TVA;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TvaServiceImpl implements TvaService{

    private TvaRepository tvaRepository;

    @Override
    public TVA saveTva(TVA tva) {
        return tvaRepository.save(tva);
    }

    @Override
    public Page<TVA> getTVAs(int page, int size) {
        Page<TVA> tvaPage = tvaRepository.findAll(PageRequest.of(page, size));
        return tvaPage;
    }

    @Override
    public List<TVA> getListTVA() {
        return tvaRepository.findAll();
    }

    @Override
    public TVA getTvaByTaux(float taux) {
        return tvaRepository.findTVAByTaux(taux);
    }

    @Override
    public TVA getTvaByID(int id) {
        return tvaRepository.findTVAByID(id);
    }

    @Override
    public void deleteTvaByID(int id) {
        tvaRepository.deleteTVAByID(id);
    }
}
