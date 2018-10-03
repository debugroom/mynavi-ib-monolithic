package org.debugroom.mynavi.ib.monolithic.app.service.common;

import org.debugroom.mynavi.ib.monolithic.app.model.common.User;

public interface CredentialService {

    public boolean authorizeBy(String secondaryPassword, User user);

}
