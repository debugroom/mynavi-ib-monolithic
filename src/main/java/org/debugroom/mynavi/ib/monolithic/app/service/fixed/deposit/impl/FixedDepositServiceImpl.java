package org.debugroom.mynavi.ib.monolithic.app.service.fixed.deposit.impl;

import java.math.BigDecimal;
import java.util.List;

import org.debugroom.mynavi.ib.monolithic.app.service.fixed.deposit.FixedDepositService;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.BusinessDay;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDeposit;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDepositAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.fixed.deposit.FixedDepositType;
import org.springframework.stereotype.Service;

@Service("fixedDepositService")
public class FixedDepositServiceImpl implements FixedDepositService {

    @Override
    public List<FixedDepositAccount> getFixedDepositAccounts(String userId) {
        return null;
    }

    @Override
    public FixedDeposit createFixedDeposit(FixedDepositType fixedDepositType, BigDecimal amount, SavingsAccount savingsAccount) {
        return null;
    }

    @Override
    public void setMaturityDayTo(FixedDeposit fixedDeposit, BusinessDay maturityDay) {

    }

    @Override
    public FixedDeposit deposit(FixedDeposit fixedDeposit) {
        return null;
    }
}
