package org.debugroom.mynavi.ib.monolithic.app.service.fixed.deposit;

import java.math.BigDecimal;
import java.util.List;

import org.debugroom.mynavi.ib.monolithic.apinfra.exception.BusinessException;

import org.debugroom.mynavi.ib.monolithic.app.model.common.BusinessDay;
import org.debugroom.mynavi.ib.monolithic.app.model.fixed.deposit.FixedDeposit;
import org.debugroom.mynavi.ib.monolithic.app.model.fixed.deposit.FixedDepositAccount;
import org.debugroom.mynavi.ib.monolithic.app.model.fixed.deposit.FixedDepositType;


public interface FixedDepositService {

    public List<FixedDepositAccount> getFixedDepositAccounts(String userId);
    public FixedDeposit createFixedDeposit(FixedDepositType fixedDepositType,
        BigDecimal amount, FixedDepositAccount fixedDepositAccount);
    public void setMaturityDayTo(FixedDeposit fixedDeposit, BusinessDay maturityDay)
            throws BusinessException;
    public void setFixedDepositRatioTo(FixedDeposit fixedDeposit, BusinessDay businessDay)
            throws BusinessException;
    public FixedDeposit deposit(FixedDeposit fixedDeposit) throws BusinessException;

}
