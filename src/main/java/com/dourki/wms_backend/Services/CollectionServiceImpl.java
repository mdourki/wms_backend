package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.CollectionRepository;
import com.dourki.wms_backend.entities.Collection;
import com.dourki.wms_backend.entities.Famille;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CollectionServiceImpl implements CollectionService{

    private CollectionRepository collectionRepository;

    @Override
    public Collection saveCollection(Collection collection) {
        return collectionRepository.save(collection);
    }

    @Override
    public Page<Collection> getCollections(int page, int size) {
        Page<Collection> collectionPage = collectionRepository.findAll(PageRequest.of(page, size));
        return collectionPage;
    }

    @Override
    public List<Collection> getListCollections() {
        return collectionRepository.findAll();
    }

    @Override
    public Collection getCollectionByNom(String Nom) {
        return collectionRepository.findCollectionByNom(Nom);
    }

    @Override
    public Collection getCollectionByID(int id) {
        return collectionRepository.findCollectionByID(id);
    }

    @Override
    public void deleteCollectionByID(int id) {
        collectionRepository.deleteCollectionByID(id);
    }
}
