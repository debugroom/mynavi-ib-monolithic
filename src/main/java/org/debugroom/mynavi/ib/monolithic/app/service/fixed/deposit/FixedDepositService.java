package org.debugroom.mynavi.ib.monolithic.app.service.fixed.deposit;

import java.math.BigDecimal;
import java.util.List;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.BusinessDay;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDeposit;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDepositAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.fixed.deposit.FixedDepositType;


public interface FixedDepositService {

    public List<FixedDepositAccount> getFixedDepositAccounts(String userId);
    public FixedDeposit createFixedDeposit(FixedDepositType fixedDepositType, BigDecimal amount, SavingsAccount savingsAccount);
    public void setMaturityDayTo(FixedDeposit fixedDeposit, BusinessDay maturityDay);
    public FixedDeposit deposit(FixedDeposit fixedDeposit);

}
