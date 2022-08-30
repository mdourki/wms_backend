package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.Collection;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CollectionService {
    Collection saveCollection(Collection collection);
    Page<Collection> getCollections(int page, int size);
    List<Collection> getListCollections();
    Collection getCollectionByNom(String Nom);
    Collection getCollectionByID(int id);
    void deleteCollectionByID(int id);
}
