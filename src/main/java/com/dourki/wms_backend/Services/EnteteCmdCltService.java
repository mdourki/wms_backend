package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.EnteteCmdClt;
import com.dourki.wms_backend.entities.Client;

public interface EnteteCmdCltService {
    EnteteCmdClt saveEnteteCmd(EnteteCmdClt enteteCmdClt);
    EnteteCmdClt findEnteteCmdByID(int id);
    EnteteCmdClt findEnteteCmdByClient(Client client);
}
