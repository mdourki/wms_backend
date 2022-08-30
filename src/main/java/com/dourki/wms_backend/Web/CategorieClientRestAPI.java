package com.dourki.wms_backend.Web;

import com.dourki.wms_backend.Services.CategorieClientService;
import com.dourki.wms_backend.Services.ClientService;
import com.dourki.wms_backend.entities.CategorieClient;
import com.dourki.wms_backend.entities.Client;
import com.dourki.wms_backend.entities.Couleur;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class CategorieClientRestAPI {

    private CategorieClientService categorieClientService;
    private ClientService clientService;

    @PostMapping("/catClt/save/{categorieClientName}")
    public String postCatClt(@PathVariable String categorieClientName) {
        CategorieClient categorie = categorieClientService.getCategorieByNom(categorieClientName);
        if(categorie == null){
            CategorieClient categorieClient = new CategorieClient();
            categorieClient.setNom(categorieClientName);
            categorieClientService.saveCategorie(categorieClient);
            return "Catégorie ajoutée";
        }
        return "Catégorie existe déjà";
    }

    @GetMapping("/listCatClt/{page}/{size}")
    public List<String> getPageCatsClt(@PathVariable int page, @PathVariable int size){
        Page<CategorieClient> categorieClientPage = categorieClientService.getCategories(page,size);
        List<String> catsClt = new ArrayList<>();
        categorieClientPage.forEach(categorieClient -> {catsClt.add(categorieClient.getNom());});
        return catsClt;
    }

    @GetMapping("/listCatClt/totalPages/{page}/{size}")
    public int getTotalPagesCatsClt(@PathVariable int page, @PathVariable int size){
        int totalPages = categorieClientService.getCategories(page,size).getTotalPages();
        return totalPages;
    }

    @PutMapping("/listCatClt/update/{id}/{categorieClientName}")
    public String updateCategorie(@PathVariable int id , @PathVariable String categorieClientName) {
        CategorieClient categorieClient = categorieClientService.getCategorieByID(id);
        CategorieClient categorieClientByNom = categorieClientService.getCategorieByNom(categorieClientName);
        if(categorieClient != null && categorieClientByNom == null)
        {
            categorieClient.setNom(categorieClientName);
            categorieClientService.saveCategorie(categorieClient);
            return "Catégorie modifiée";
        }
        return "Catégorie non modifiée";
    }

    @DeleteMapping("/listCatClt/delete/{id}")
    public String deleteCategorie(@PathVariable int id ){
        CategorieClient categorieClient = categorieClientService.getCategorieByID(id);
        List<Client> clients = clientService.getListClients();
        for (Client client:clients) {
            if (client.getCategorie().getID() == id) {
                return "Impossible de supprimer cette catégorie, car elle est associée à un client";
            }
        }
        if(categorieClient != null)
        {
            categorieClientService.deleteCategorieByID(id);
            return "Catégorie supprimée";
        }
        return "Catégorie non supprimée";
    }

    @GetMapping("/listCatClt/getID/{categorieClientName}")
    public int getCategorieIDByNom(@PathVariable String categorieClientName){
        CategorieClient categorieClient = categorieClientService.getCategorieByNom(categorieClientName);
        if(categorieClient != null)
        {
            return categorieClient.getID();
        }
        return -1;
    }

    @GetMapping("/listCatClt/getByID/{ID}")
    public CategorieClient getCategorieByID(@PathVariable int ID) {
        return categorieClientService.getCategorieByID(ID);
    }

    @GetMapping("/listCatClt/getAllCategoriesNames")
    public List<String> getListCategoriesNames(){
        List<CategorieClient> categorieClientList = categorieClientService.getListCategories();
        List<String> listNames = new ArrayList<>();
        categorieClientList.forEach(categorieClient ->  {listNames.add(categorieClient.getNom());});
        return listNames;
    }
}
