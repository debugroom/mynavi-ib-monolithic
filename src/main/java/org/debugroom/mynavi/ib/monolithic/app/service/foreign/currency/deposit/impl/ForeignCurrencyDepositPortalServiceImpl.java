package org.debugroom.mynavi.ib.monolithic.app.service.foreign.currency.deposit.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.debugroom.mynavi.ib.monolithic.app.model.common.PortalResource;
import org.debugroom.mynavi.ib.monolithic.app.model.common.UserMapper;
import org.debugroom.mynavi.ib.monolithic.app.model.foreign.currency.deposit.ForeignCurrencyDepositAccountMapper;
import org.debugroom.mynavi.ib.monolithic.app.model.foreign.currency.deposit.ForeignCurrencyDepositPortalResource;
import org.debugroom.mynavi.ib.monolithic.app.service.common.PortalService;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.ForeignCurrencyDepositAccountRepository;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.UserRepository;

@Service("foreignCurrencyDepositPortalService")
public class ForeignCurrencyDepositPortalServiceImpl implements PortalService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ForeignCurrencyDepositAccountRepository foreignCurrencyDepositAccountRepository;

    @Override
    public PortalResource getPortalResource(String userId) {
        PortalResource portalResource = ForeignCurrencyDepositPortalResource.builder()
                .user(UserMapper.createByEntity(userRepository.getOne(userId)))
                .foreignCurrencyDepositAccounts(
                        foreignCurrencyDepositAccountRepository.findByUserId(userId)
                                .stream().map(ForeignCurrencyDepositAccountMapper::createFromEntity)
                                .collect(Collectors.toList()))
                .build();
        return portalResource;
    }

}
