package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.Client;
import com.dourki.wms_backend.entities.EnteteLivClt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnteteLivCltRepository extends JpaRepository<EnteteLivClt, Integer> {
 EnteteLivClt findEnteteLivCltByID(int id);
 EnteteLivClt findEnteteLivCltByClient(Client client);
}
