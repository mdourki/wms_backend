package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.Client;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClientService {
    Client saveClient(Client client);
    Page<Client> getClients(int page, int size);
    List<Client> getListClients();
    Client getClientByID(int id);
    Client getClientByNomAndAdresseAndNumTelAndEmail(String nom,String adresse, String numTel, String email);
    void deleteClientByID(int id);
}
