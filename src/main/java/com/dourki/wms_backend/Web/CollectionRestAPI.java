package com.dourki.wms_backend.Web;

import com.dourki.wms_backend.Services.CollectionService;
import com.dourki.wms_backend.Services.ProduitService;
import com.dourki.wms_backend.entities.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class CollectionRestAPI {

    private CollectionService collectionService;
    private ProduitService produitService;

    @PostMapping("/collections/save/{collectionName}")
    public String postCollection(@PathVariable String collectionName) {
        Collection collection = collectionService.getCollectionByNom(collectionName);
        if(collection == null){
            Collection collection1 = new Collection();
            collection1.setNom(collectionName);
            collectionService.saveCollection(collection1);
            return "Collection ajoutée";
        }
        return "Collection existe déjà";
    }

    @GetMapping("/collections/{page}/{size}")
    public List<String> getPageCollections(@PathVariable int page, @PathVariable int size){
        Page<Collection> collectionPage = collectionService.getCollections(page,size);
        List<String> collections = new ArrayList<>();
        collectionPage.forEach(collection -> {collections.add(collection.getNom());});
        return collections;
    }

    @GetMapping("/collections/totalPages/{page}/{size}")
    public int getTotalPagesCollections(@PathVariable int page, @PathVariable int size){
        int totalPages = collectionService.getCollections(page,size).getTotalPages();
        return totalPages;
    }

    @PutMapping("/collections/update/{id}/{collectionName}")
    public String updateCollection(@PathVariable int id , @PathVariable String collectionName) {
        Collection collection = collectionService.getCollectionByID(id);
        Collection collectionByNom = collectionService.getCollectionByNom(collectionName);
        if(collection != null && collectionByNom == null)
        {
            collection.setNom(collectionName);
            collectionService.saveCollection(collection);
            return "Collection modifiée";
        }
        return "Collection non modifiée";
    }

    @DeleteMapping("/collections/delete/{id}")
    public String deleteCollection(@PathVariable int id ){
        Collection collection = collectionService.getCollectionByID(id);
        List<Produit> produits = produitService.getListProduits();
        for (Produit produit:produits) {
            if (produit.getCollection().getID() == id) {
                    return "Impossible de supprimer cette collection, car elle est associée à un produit";
            }
        }
        if(collection != null)
        {
            collectionService.deleteCollectionByID(id);
            return "Collection supprimée";
        }
        return "Collection non supprimée";
    }

    @GetMapping("/collections/getID/{collectionName}")
    public int getCollectionIDByNom(@PathVariable String collectionName){
        Collection collection = collectionService.getCollectionByNom(collectionName);
        if(collection != null)
        {
            return collection.getID();
        }
        return -1;
    }

    @GetMapping("/collections/getByID/{ID}")
    public Collection getCollectionByID(@PathVariable int ID) {
        return collectionService.getCollectionByID(ID);
    }

    @GetMapping("/collections/getAllCollectionsNames")
    public List<String> getListCollectionsNames(){
        List<Collection> collectionList = collectionService.getListCollections();
        List<String> listNames = new ArrayList<>();
        collectionList.forEach(collection ->  {listNames.add(collection.getNom());});
        return listNames;
    }
}
