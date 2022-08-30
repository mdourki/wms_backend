package com.dourki.wms_backend.Services;

import com.dourki.wms_backend.entities.EnteteFactClt;
import com.dourki.wms_backend.entities.Client;

public interface EnteteFactCltService {
    EnteteFactClt saveEnteteFact(EnteteFactClt enteteFactClt);
    EnteteFactClt findEnteteFactByID(int id);
    EnteteFactClt findEnteteFactByClient(Client client);
}
