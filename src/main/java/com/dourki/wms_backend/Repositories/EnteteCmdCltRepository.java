package com.dourki.wms_backend.Repositories;

import com.dourki.wms_backend.entities.EnteteCmdClt;
import com.dourki.wms_backend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnteteCmdCltRepository extends JpaRepository<EnteteCmdClt , Integer> {
 EnteteCmdClt findEnteteCmdCltByID(int id);
 EnteteCmdClt findEnteteCmdCltByClient(Client client);
}
