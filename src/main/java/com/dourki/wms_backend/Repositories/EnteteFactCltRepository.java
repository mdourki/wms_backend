package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.EnteteFactClt;
import com.dourki.wms_backend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnteteFactCltRepository extends JpaRepository<EnteteFactClt , Integer> {
 EnteteFactClt findEnteteFactCltByID(int id);
 EnteteFactClt findEnteteFactCltByClient(Client client);
}
