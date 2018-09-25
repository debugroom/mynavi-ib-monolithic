package org.debugroom.mynavi.ib.monolithic.app.service.ordinary.deposit;

import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.Deposit;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccount;

import java.util.List;

public interface DepositService {

    public List<Deposit> getAllDeposits(SavingsAccount savingsAccount);
    public List<SavingsAccount> getSavingsAccounts(String userId);

}
