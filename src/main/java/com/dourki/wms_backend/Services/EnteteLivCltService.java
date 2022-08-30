package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.EnteteLivClt;
import com.dourki.wms_backend.entities.Client;

public interface EnteteLivCltService {
    EnteteLivClt saveEnteteLiv(EnteteLivClt enteteLivClt);
    EnteteLivClt findEnteteLivByID(int id);
    EnteteLivClt findEnteteLivByClient(Client client);
}
