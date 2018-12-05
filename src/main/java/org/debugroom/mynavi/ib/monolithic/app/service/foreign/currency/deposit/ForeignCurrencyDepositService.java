package org.debugroom.mynavi.ib.monolithic.app.service.foreign.currency.deposit;

import java.math.BigDecimal;
import java.util.List;

import org.debugroom.mynavi.ib.monolithic.app.model.common.AccountType;
import org.debugroom.mynavi.ib.monolithic.app.model.common.RiskAnswer;
import org.debugroom.mynavi.ib.monolithic.app.model.foreign.currency.deposit.ExchangeRate;
import org.debugroom.mynavi.ib.monolithic.app.model.foreign.currency.deposit.ForeginCurrencyDepositType;
import org.debugroom.mynavi.ib.monolithic.app.model.foreign.currency.deposit.ForeignCurrencyDeposit;
import org.debugroom.mynavi.ib.monolithic.app.model.foreign.currency.deposit.ForeignCurrencyDepositAccount;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccount;

public interface ForeignCurrencyDepositService {

    public List<RiskAnswer> getRiskAnswers(String userId);
    public List<SavingsAccount> getSavingsAccounts(String userId);
    public ForeignCurrencyDeposit createForeignCurrencyDeposit(
            ForeginCurrencyDepositType foreginCurrencyDepositType, BigDecimal amount,
            ForeignCurrencyDepositAccount foreignCurrencyDepositAccount);
    public ExchangeRate getCurrentExchangeRate();

}
