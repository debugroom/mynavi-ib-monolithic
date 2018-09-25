package org.debugroom.mynavi.ib.monolithic.domain.component.fixed.deposit;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDeposit;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDepositAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount;

public interface FixedDepositAccountManipulator {

    public void addFixedDepositTo(
            FixedDepositAccount fixedDepositAccount, FixedDeposit addFixedDeposit);
    public void cancelFixedDepositFrom(
            FixedDepositAccount fixedDepositAccount, FixedDeposit cancelFixedDeposit);
    public void changeRelatedSavingsAccount(
            SavingsAccount fromSavingsAccount, SavingsAccount toSavingsAccount);

}
