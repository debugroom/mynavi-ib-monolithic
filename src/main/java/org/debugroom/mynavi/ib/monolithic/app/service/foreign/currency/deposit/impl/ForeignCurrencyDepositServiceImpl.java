package org.debugroom.mynavi.ib.monolithic.app.service.foreign.currency.deposit.impl;

import org.debugroom.mynavi.ib.monolithic.app.model.common.RiskAnswer;
import org.debugroom.mynavi.ib.monolithic.app.model.common.RiskAnswerMapper;
import org.debugroom.mynavi.ib.monolithic.app.model.foreign.currency.deposit.ExchangeRate;
import org.debugroom.mynavi.ib.monolithic.app.model.foreign.currency.deposit.ForeginCurrencyDepositType;
import org.debugroom.mynavi.ib.monolithic.app.model.foreign.currency.deposit.ForeignCurrencyDeposit;
import org.debugroom.mynavi.ib.monolithic.app.model.foreign.currency.deposit.ForeignCurrencyDepositAccount;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccount;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccountMapper;
import org.debugroom.mynavi.ib.monolithic.app.service.foreign.currency.deposit.ForeignCurrencyDepositService;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForeignCurrencyDepositServiceImpl implements ForeignCurrencyDepositService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<RiskAnswer> getRiskAnswers(String userId) {
        return userRepository.getOne(userId).inquireRiskAnswers().stream()
                .map(RiskAnswerMapper::createByEntity).collect(Collectors.toList());
    }

    @Override
    public List<SavingsAccount> getSavingsAccounts(String userId) {
        return userRepository.getOne(userId).getSavingsAccountsByUserId().stream()
                .map(SavingsAccountMapper::createFromEntity).collect(Collectors.toList());
    }

    @Override
    public ForeignCurrencyDeposit createForeignCurrencyDeposit(
            ForeginCurrencyDepositType foreginCurrencyDepositType, BigDecimal amount,
            ForeignCurrencyDepositAccount foreignCurrencyDepositAccount) {
        return ForeignCurrencyDeposit.builder()
                .financialCode(foreignCurrencyDepositAccount.getFinancialCode())
                .branchId(foreignCurrencyDepositAccount.getBranchId())
                .accountNo(foreignCurrencyDepositAccount.getAccountNo())
                .foreignCurrencyAccountNo(foreignCurrencyDepositAccount.getForeignCurrencyAccountNo())
                .foreginCurrencyDepositType(foreginCurrencyDepositType)
                .balance(amount)
                .build();
    }

    @Override
    public ExchangeRate getCurrentExchangeRate() {
        return null;
    }

}
