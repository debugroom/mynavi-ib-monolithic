package org.debugroom.mynavi.ib.monolithic.app.service.fixed.deposit.impl;

import org.debugroom.mynavi.ib.monolithic.app.model.common.PortalResource;
import org.debugroom.mynavi.ib.monolithic.app.model.common.UserMapper;
import org.debugroom.mynavi.ib.monolithic.app.model.fixed.deposit.FixedDepositAccountMapper;
import org.debugroom.mynavi.ib.monolithic.app.model.fixed.deposit.FixedDepositPortalResource;
import org.debugroom.mynavi.ib.monolithic.app.service.common.PortalService;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.FixedDepositAccountRepository;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service("fixedDepositPortalService")
public class FixedDepositPortalServiceImpl implements PortalService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FixedDepositAccountRepository fixedDepositAccountRepository;

    @Override
    public PortalResource getPortalResource(String userId) {
        PortalResource portalResource = FixedDepositPortalResource.builder()
                .user(UserMapper.createByEntity(userRepository.getOne(userId)))
                .fixedDepositAccounts(fixedDepositAccountRepository.findByUserId(userId)
                        .stream().map(FixedDepositAccountMapper::createFromEntity)
                        .collect(Collectors.toList()))
                .build();
        return portalResource;
    }

}
