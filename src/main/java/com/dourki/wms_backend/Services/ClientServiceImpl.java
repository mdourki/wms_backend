package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.Repositories.ClientRepository;
import com.dourki.wms_backend.entities.Client;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{

    private ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Page<Client> getClients(int page, int size) {
        return clientRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Client> getListClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientByID(int id) {
        return clientRepository.findClientByID(id);
    }

    @Override
    public Client getClientByNomAndAdresseAndNumTelAndEmail(String nom, String adresse, String numTel, String email) {
        return clientRepository.findClientByNomAndAdresseAndNumTelAndEmail(nom, adresse, numTel, email);
    }

    @Override
    public void deleteClientByID(int id) {
        clientRepository.deleteClientByID(id);
    }
}
