package org.debugroom.mynavi.ib.monolithic.domain.component.ordinary.deposit.impl;

import org.debugroom.mynavi.ib.monolithic.apinfra.exception.BusinessException;
import org.debugroom.mynavi.ib.monolithic.domain.component.ordinary.deposit.SavingsAccountManipulator;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.Deposit;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccountPK;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.SavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Objects;

@Component
@Transactional
public class SavingsAccountManipulatorImpl implements SavingsAccountManipulator {

    @Autowired
    SavingsAccountRepository savingsAccountRepository;

    @Override
    public void addDepositTo(SavingsAccount savingsAccount, Deposit addDeposit)
                                                        throws BusinessException{
        SavingsAccount targetSavingsAccount = getSavingsAccount(savingsAccount);
        targetSavingsAccount.getDeposits().add(addDeposit);
        addTotalAmountOf(targetSavingsAccount, new BigDecimal(addDeposit.getBalance()));
        savingsAccountRepository.save(targetSavingsAccount);
    }

    @Override
    public void addTotalAmountOf(SavingsAccount savingsAccount, BigDecimal addMoney)
            throws BusinessException {
        SavingsAccount targetSavingsAccount = savingsAccountRepository.getOne(
                SavingsAccountPK.builder()
                        .userId(savingsAccount.getUserId())
                        .financialCode(savingsAccount.getFinancialCode())
                        .branchId(savingsAccount.getBranchId())
                        .accountNo(savingsAccount.getAccountNo())
                        .build());
        BigDecimal totalAmount = new BigDecimal(
                targetSavingsAccount.getTotalAmount()).add(addMoney);
        targetSavingsAccount.setTotalAmount(totalAmount.toBigInteger());
    }

    @Override
    public void subtractTotalAmountOf(SavingsAccount savingsAccount, BigDecimal subtractMoney)
            throws BusinessException{
        SavingsAccount targetSavingsAccount = savingsAccountRepository.getOne(
                SavingsAccountPK.builder()
                        .userId(savingsAccount.getUserId())
                        .financialCode(savingsAccount.getFinancialCode())
                        .branchId(savingsAccount.getBranchId())
                        .accountNo(savingsAccount.getAccountNo())
                .build());
        if(targetSavingsAccount.getTotalAmount().compareTo(
                subtractMoney.toBigInteger()) < 0){
            throw new BusinessException("error.ordinary.deposit.0002",
                    "Insufficient balance for transfer order in finacode: [1], branch: [2], account: [3]",
                    savingsAccount.getFinancialCode(), savingsAccount.getBranchId(),
                    savingsAccount.getAccountNo());
        }
        BigDecimal totalAmount = new BigDecimal(targetSavingsAccount
                .getTotalAmount()).subtract(subtractMoney);
        targetSavingsAccount.setTotalAmount(totalAmount.toBigInteger());
    }

    private SavingsAccount getSavingsAccount(SavingsAccount savingsAccount) throws BusinessException{
        SavingsAccount targetSavingsAccount = savingsAccountRepository.getOne(
                SavingsAccountPK.builder()
                        .userId(savingsAccount.getUserId())
                        .financialCode(savingsAccount.getFinancialCode())
                        .branchId(savingsAccount.getBranchId())
                        .accountNo(savingsAccount.getAccountNo())
                        .build());
        if(Objects.isNull(targetSavingsAccount)){
            throw new BusinessException("error.ordinary.deposit.0001",
                    "Not found user which has finacode: [1], branch: [2], account: [3]",
                    savingsAccount.getFinancialCode(), savingsAccount.getBranchId(),
                    savingsAccount.getAccountNo());

        }
        return targetSavingsAccount;
    }
}
