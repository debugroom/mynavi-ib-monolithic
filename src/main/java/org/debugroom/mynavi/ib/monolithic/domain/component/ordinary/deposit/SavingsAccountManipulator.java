package org.debugroom.mynavi.ib.monolithic.domain.component.ordinary.deposit;

import java.math.BigDecimal;

import org.debugroom.mynavi.ib.monolithic.apinfra.exception.BusinessException;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.Deposit;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount;

public interface SavingsAccountManipulator {

    public void addDepositTo(SavingsAccount savingsAccount, Deposit addDeposit) throws BusinessException;
    public void addTotalAmountOf(SavingsAccount savingsAccount, BigDecimal addMoney) throws BusinessException;
    public void subtractTotalAmountOf(SavingsAccount savingsAccount, BigDecimal subtractMoney) throws BusinessException;

}
