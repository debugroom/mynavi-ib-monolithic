package org.debugroom.mynavi.ib.monolithic.app.service.fixed.deposit.impl;

import java.math.BigDecimal;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.debugroom.mynavi.ib.monolithic.apinfra.exception.BusinessException;
import org.debugroom.mynavi.ib.monolithic.app.model.common.BusinessDay;
import org.debugroom.mynavi.ib.monolithic.app.model.fixed.deposit.*;
import org.debugroom.mynavi.ib.monolithic.app.service.fixed.deposit.FixedDepositService;
import org.debugroom.mynavi.ib.monolithic.domain.service.common.CalendarService;
import org.debugroom.mynavi.ib.monolithic.domain.service.fixed.deposit.FixedDepositFacade;

@Service("fixedDepositService")
public class FixedDepositServiceImpl implements FixedDepositService {

    @Autowired
    FixedDepositFacade fixedDepositFacade;

    @Autowired
    CalendarService calendarService;

    @Override
    public List<FixedDepositAccount> getFixedDepositAccounts(String userId) {
        return fixedDepositFacade.inquiryFixedDepositAccounts(userId).stream()
                .map(FixedDepositAccountMapper::createFromEntityWithSavingsAccount)
                .collect(Collectors.toList());
    }

    @Override
    public FixedDeposit createFixedDeposit(FixedDepositType fixedDepositType,
               BigDecimal amount, FixedDepositAccount fixedDepositAccount) {
        return FixedDeposit.builder()
                .financialCode(fixedDepositAccount.getFinancialCode())
                .branchId(fixedDepositAccount.getBranchId())
                .accountNo(fixedDepositAccount.getAccountNo())
                .fixedAccountNo(fixedDepositAccount.getFixedAccountNo())
                .fixedDepositType(fixedDepositType)
                .balance(amount)
                .build();
    }

    @Override
    public void setMaturityDayTo(FixedDeposit fixedDeposit, BusinessDay maturityDay)
            throws BusinessException {
        if(!calendarService.isBusinessDay(maturityDay.getYyyymmdd())){
            throw new BusinessException("error.fixed.deposit.0001",
                    "Not business day. [1]", maturityDay.getYyyymmdd());
        }
        fixedDeposit.setMaturityDay(maturityDay.getYyyymmdd());
    }

    @Override
    public void setFixedDepositRatioTo(FixedDeposit fixedDeposit, BusinessDay businessDay)
            throws BusinessException {
        if(!calendarService.isBusinessDay(businessDay.getYyyymmdd())){
            throw new BusinessException("error.fixed.deposit.0001",
                    "Not business day. [1]", businessDay.getYyyymmdd());
        }
        fixedDeposit.setRatio(fixedDepositFacade.getRatio(
                fixedDeposit.getFixedDepositType().toString(), businessDay.getYyyymmdd()));
    }

    @Override
    public FixedDeposit deposit(FixedDeposit fixedDeposit) throws BusinessException{
        if(!fixedDepositFacade.haveBalanceFor(
                FixedDepositMapper.createEntity(fixedDeposit))){
            throw new BusinessException("error.fixed.deposit.0002",
                    "Lack of balance for FixedDeposit.", fixedDeposit.getFinancialCode(),
                    fixedDeposit.getBranchId(), fixedDeposit.getAccountNo());
        }
        return FixedDepositMapper.createFromEntity(
                fixedDepositFacade.deposit(FixedDepositMapper.createEntity(fixedDeposit)));
    }

}
