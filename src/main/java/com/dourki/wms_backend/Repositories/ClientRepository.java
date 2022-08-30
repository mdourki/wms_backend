package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.CategorieClient;
import com.dourki.wms_backend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findClientByNomAndAdresseAndNumTelAndEmail(String nom,String adresse, String numTel, String email);
    Client findClientByID(int id);
    void deleteClientByID(int id);
}
