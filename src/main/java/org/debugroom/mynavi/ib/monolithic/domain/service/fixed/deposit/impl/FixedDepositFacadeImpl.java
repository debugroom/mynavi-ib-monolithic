package org.debugroom.mynavi.ib.monolithic.domain.service.fixed.deposit.impl;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.debugroom.mynavi.ib.monolithic.apinfra.exception.BusinessException;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDeposit;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDepositAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccountPK;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.DepositRatio;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.DepositRatioRepository;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.FixedDepositAccountRepository;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.FixedDepositRepository;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.SavingsAccountRepository;
import org.debugroom.mynavi.ib.monolithic.domain.service.fixed.deposit.FixedDepositFacade;
import org.springframework.stereotype.Service;

@Service("fixedDepositFacadeImpl")
public class FixedDepositFacadeImpl implements FixedDepositFacade {

    @Autowired
    FixedDepositAccountRepository fixedDepositAccountRepository;

    @Autowired
    DepositRatioRepository depositRatioRepository;

    @Autowired
    SavingsAccountRepository savingsAccountRepository;

    @Autowired
    FixedDepositRepository fixedDepositRepository;

    @Override
    public List<FixedDepositAccount> inquiryFixedDepositAccounts(String userId) {
        return fixedDepositAccountRepository.findByUserId(userId);
    }

    @Override
    public boolean haveBalanceFor(FixedDeposit fixedDeposit) {
        SavingsAccount savingsAccount = savingsAccountRepository.getOne(
                SavingsAccountPK.builder()
                        .userId(fixedDeposit.getUserId())
                        .financialCode(fixedDeposit.getFinancialCode())
                        .branchId(fixedDeposit.getBranchId())
                        .accountNo(fixedDeposit.getAccountNo()).build());
        return fixedDeposit.getBalance().compareTo(savingsAccount.getTotalAmount()) < 0;
    }

    @Override
    public BigDecimal getRatio(String depositType, String tradeDay) {
        List<DepositRatio> validDepositRatioList = depositRatioRepository
                .findByDepositType(depositType).stream()
                .filter(depositRatio -> depositRatio.getValidStartDay().compareTo(tradeDay)<0)
                .sorted((depositRatio1, depositRatio2)->
                        depositRatio1.getValidStartDay().compareTo(depositRatio2.getValidStartDay()))
                .collect(Collectors.toList());
        return new BigDecimal(validDepositRatioList.get(0).getRatio());
    }

    @Override
    public FixedDeposit deposit(FixedDeposit fixedDeposit) throws BusinessException {
        SavingsAccount savingsAccount = savingsAccountRepository.getOne(
                SavingsAccountPK.builder()
                        .userId(fixedDeposit.getUserId())
                        .financialCode(fixedDeposit.getFinancialCode())
                        .branchId(fixedDeposit.getBranchId())
                        .accountNo(fixedDeposit.getAccountNo())
                        .build());
        savingsAccount.setTotalAmount(
                savingsAccount.getTotalAmount().subtract(fixedDeposit.getBalance()));
        savingsAccountRepository.save(savingsAccount);
        fixedDeposit.setTradeId(UUID.randomUUID().toString());
        fixedDeposit.setLastUpdatedAt(Timestamp.from(ZonedDateTime.now().toInstant()));
        fixedDeposit.setVer(0);
        fixedDeposit.setTransactionStatus("COMPLETED");
        return fixedDepositRepository.save(fixedDeposit);
    }

}
