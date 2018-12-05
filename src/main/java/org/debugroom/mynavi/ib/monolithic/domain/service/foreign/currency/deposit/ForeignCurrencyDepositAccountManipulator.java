package org.debugroom.mynavi.ib.monolithic.domain.service.foreign.currency.deposit;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.ForeignCurrencyDeposit;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.ForeignCurrencyDepositAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount;

public interface ForeignCurrencyDepositAccountManipulator {

    public void addForeignCurrencyDepositTo(
            ForeignCurrencyDepositAccount foreignCurrencyDepositAccout,
            ForeignCurrencyDeposit addForeignCurrencyDeposit);
    public void cancelForeignCurrencyDepositFrom(
            ForeignCurrencyDepositAccount foreignCurrencyDepositAccout,
            ForeignCurrencyDeposit cancelForeignCurrencyDeposit);
    public void changeRelatedSavingsAccount(
            SavingsAccount fromSavingsAccount, SavingsAccount toSavingsAccount);

}
