package org.debugroom.mynavi.ib.monolithic.app.service.ordinary.deposit.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.debugroom.mynavi.ib.monolithic.app.model.common.User;
import org.debugroom.mynavi.ib.monolithic.app.model.common.UserMapper;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccountMapper;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.Deposit;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccount;
import org.debugroom.mynavi.ib.monolithic.app.service.ordinary.deposit.DepositService;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccountPK;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.UserRepository;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.SavingsAccountRepository;

@Service("depositService")
public class DepositServiceImpl implements DepositService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SavingsAccountRepository savingsAccountRepository;

    @Override
    public List<Deposit> getAllDeposits(SavingsAccount savingsAccount) {
        SavingsAccount savingsAccount1 = SavingsAccountMapper
                .createFromEntityWithDeposits(
                        savingsAccountRepository.getOne(
                                SavingsAccountPK
                                        .builder()
                                        .userId(savingsAccount.getUserId())
                                .financialCode(savingsAccount.getFinancialCode())
                                .branchId(savingsAccount.getBranchId())
                                .accountNo(savingsAccount.getAccountNo())
                                .build()
                        ));
        return savingsAccount1.getDeposits();
    }

    @Override
    public List<SavingsAccount> getSavingsAccounts(String userId) {
        User user = UserMapper.createByEntity(userRepository.getOne(userId));
        return user.getSavingsAccounts();
    }

}
