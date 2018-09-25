package org.debugroom.mynavi.ib.monolithic.domain.component.foreign.currency.deposit;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.ForeignCurrencyDeposit;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.ForeignCurrencyDepositAccout;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount;

public interface ForeignCurrencyDepositAccountManipulator {

    public void addForeignCurrencyDepositTo(
            ForeignCurrencyDepositAccout foreignCurrencyDepositAccout,
            ForeignCurrencyDeposit addForeignCurrencyDeposit);
    public void cancelForeignCurrencyDepositFrom(
            ForeignCurrencyDepositAccout foreignCurrencyDepositAccout,
            ForeignCurrencyDeposit cancelForeignCurrencyDeposit);
    public void changeRelatedSavingsAccount(
            SavingsAccount fromSavingsAccount, SavingsAccount toSavingsAccount);

}
