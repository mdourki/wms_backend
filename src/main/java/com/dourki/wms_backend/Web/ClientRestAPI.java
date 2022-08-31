package com.dourki.wms_backend.Web;

import com.dourki.wms_backend.Services.CategorieClientService;
import com.dourki.wms_backend.Services.ClientService;
import com.dourki.wms_backend.entities.CategorieClient;
import com.dourki.wms_backend.entities.Client;
import com.dourki.wms_backend.entities.Fournisseur;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class ClientRestAPI {

    private ClientService clientService;
    private CategorieClientService categorieClientService;

    @PostMapping("/clients/save/{nom}/{adresse}/{numTel}/{email}/{categorieID}")
    public String postClient(@PathVariable String nom ,
                            @PathVariable String adresse ,
                            @PathVariable String numTel ,
                            @PathVariable String email ,
                            @PathVariable int categorieID ) {
        CategorieClient categorieClient = categorieClientService.getCategorieByID(categorieID);
        Client client = clientService.
                getClientByNomAndAdresseAndNumTelAndEmail(nom , adresse , numTel , email);

        if(client == null){
            Client client1 = new Client();
            client1.setNom(nom);
            client1.setAdresse(adresse);
            client1.setNumTel(numTel);
            client1.setEmail(email);
            client1.setCategorie(categorieClient);
            clientService.saveClient(client1);
            return "Client ajouté";
        }
        return "Client existe déjà";
    }

    @GetMapping("/clients/{page}/{size}")
    public List<List<String>> getPageClients(@PathVariable int page, @PathVariable int size){
        Page<Client> clientPage = clientService.getClients(page,size);
        List<List<String>> list = new ArrayList<>();
        clientPage.forEach(client -> { list.add(client.getInfo()); });
        return list;
    }

    @GetMapping("/clients/totalPages/{page}/{size}")
    public int getTotalPagesClients(@PathVariable int page, @PathVariable int size){
        return clientService.getClients(page,size).getTotalPages();
    }

    @PutMapping("/clients/update/{id}/{nom}/{adresse}/{numTel}/{email}/{categorieID}")
    public String updateClient(@PathVariable int id ,
                               @PathVariable String nom ,
                               @PathVariable String adresse ,
                               @PathVariable String numTel ,
                               @PathVariable String email ,
                               @PathVariable int categorieID ) {
        Client client = clientService.getClientByID(id);
        CategorieClient categorieClient = categorieClientService.getCategorieByID(categorieID);
        Client client1 = clientService.
                getClientByNomAndAdresseAndNumTelAndEmail(nom , adresse , numTel , email);
        if(client != null && client1 == null)
        {
            client.setNom(nom);
            client.setAdresse(adresse);
            client.setNumTel(numTel);
            client.setEmail(email);
            client.setCategorie(categorieClient);
            clientService.saveClient(client);
            return "Client modifié";
        }
            return "Client non modifié";
    }

    @DeleteMapping("/clients/delete/{id}")
    public String deleteClient(@PathVariable int id ){
        Client client = clientService.getClientByID(id);
        if(client != null)
        {
            clientService.deleteClientByID(id);
            return "Client supprimé";
        }
        return "Client non supprimé";
    }

    @GetMapping("/clients/getByID/{ID}")
    public Client getClientByID(@PathVariable int ID) {
        return clientService.getClientByID(ID);
    }

    @GetMapping("/clients/getID/{clientName}")
    public int getClientIDByNom(@PathVariable String clientName) {
        return clientService.getClientByNom(clientName).getID();
    }

    @GetMapping("/clients/getAllClientsNames")
    public List<String> getAllClientsNames() {
        List<String> listNames = new ArrayList<>();
        List<Client> clients = clientService.getListClients();
        for (Client client : clients){
            listNames.add(client.getNom());
        }
        return listNames;
    }

}
