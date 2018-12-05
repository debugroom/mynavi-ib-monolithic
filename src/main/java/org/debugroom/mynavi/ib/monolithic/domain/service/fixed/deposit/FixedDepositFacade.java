package org.debugroom.mynavi.ib.monolithic.domain.service.fixed.deposit;

import java.math.BigDecimal;
import java.util.List;

import org.debugroom.mynavi.ib.monolithic.apinfra.exception.BusinessException;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDeposit;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDepositAccount;

public interface FixedDepositFacade {

    public List<FixedDepositAccount> inquiryFixedDepositAccounts(String userId);
    public BigDecimal getRatio(String depositType, String tradeDay);
    public boolean haveBalanceFor(FixedDeposit fixedDeposit);
    public FixedDeposit deposit(FixedDeposit fixedDeposit) throws BusinessException;

}
