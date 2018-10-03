package org.debugroom.mynavi.ib.monolithic.app.service.ordinary.deposit.impl;

import org.debugroom.mynavi.ib.monolithic.app.model.common.PortalResource;
import org.debugroom.mynavi.ib.monolithic.app.model.common.User;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.DepositPortalResource;
import org.debugroom.mynavi.ib.monolithic.app.service.common.PortalService;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("depositPortalService")
public class DepositPortalServiceImpl implements PortalService {

    @Autowired
    UserRepository userRepository;

    @Override
    public PortalResource getPortalResource(String userId) {
        PortalResource portalResource =
                DepositPortalResource.builder()
                        .user(User.createFromEntity(userRepository.getOne(userId)))
                        .build();
        return portalResource;
    }

}
