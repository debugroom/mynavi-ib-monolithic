package org.debugroom.mynavi.ib.monolithic.domain.service.ordinary.deposit.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.debugroom.mynavi.ib.monolithic.apinfra.exception.BusinessException;
import org.debugroom.mynavi.ib.monolithic.domain.DomainProperties;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccountPK;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.Transfer;
import org.debugroom.mynavi.ib.monolithic.domain.model.ordinary.deposit.TransferOrder;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.SavingsAccountRepository;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.TransferRepository;
import org.debugroom.mynavi.ib.monolithic.domain.service.ordinary.deposit.TransferFacade;

@Transactional
@Service("transferFacade")
public class TransferFacadeImpl implements TransferFacade {

    @Autowired
    DomainProperties domainProperties;

    @Autowired
    SavingsAccountRepository savingsAccountRepository;

    @Autowired
    TransferRepository transferRepository;

    @Override
    public SavingsAccount inquirySavingAccount(
            String userId, String financialCode, String branchId, String accountNo) {
        return savingsAccountRepository.getOne(SavingsAccountPK.builder()
                .userId(userId).financialCode(financialCode)
                .branchId(branchId).accountNo(accountNo).build());
    }

    @Override
    public boolean canTransfer(Transfer transfer) {
        SavingsAccount transferFromAccount = savingsAccountRepository.getOne(
                SavingsAccountPK.builder()
                        .userId(transfer.getUserId())
                        .financialCode(transfer.getFinancialCode())
                        .branchId(transfer.getBranchId())
                        .accountNo(transfer.getAccountNo())
                        .build());
        if(transfer.getAmount().add(getFee(transfer).toBigInteger())
                .compareTo(transferFromAccount.getTotalAmount()) < 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean existsTransferToSavingsAccount(SavingsAccount savingsAccount) {
        return savingsAccountRepository.existsById(SavingsAccountPK.builder()
                .userId(savingsAccount.getUserId())
                .financialCode(savingsAccount.getFinancialCode())
                .branchId(savingsAccount.getBranchId())
                .accountNo(savingsAccount.getAccountNo())
                .build());
    }

    @Override
    public BigDecimal getFee(Transfer transfer) {
        if(transfer.getAmount().compareTo(domainProperties.getTransferFeeBoundaryPrice().toBigInteger())<0){
            if(transfer.getFinancialCode().equals(transfer.getTransferToFinancialCode())){
                return domainProperties.getTransferFeeLowForSameFinancialInstition();
            }
            return domainProperties.getTransferFeeLowForOtherFinancialInstition();
        }
        if(transfer.getFinancialCode().equals(transfer.getTransferToFinancialCode())){
            return domainProperties.getTransferFeeHighForSameFinancialInstition();
        }
        return domainProperties.getTransferFeeHignForOtherFinancialInstition();
    }

    @Override
    public Transfer reserveTransfer(Transfer transfer) {
        transfer.setTradeId(UUID.randomUUID().toString());
        transfer.setTransactionStatus("RESERVED");
        transfer.setLastUpdatedAt(Timestamp.from(ZonedDateTime.now().toInstant()));
        transfer.setVer(0);
        transferRepository.save(transfer);
        return transfer;
    }

    @Override
    public void transfer(TransferOrder transferOrder) throws BusinessException {
        SavingsAccount fromAccount = savingsAccountRepository.getOne(
                SavingsAccountPK.builder()
                        .userId(transferOrder.getTransfer().getUserId())
                        .financialCode(transferOrder.getTransfer().getFinancialCode())
                        .branchId(transferOrder.getTransfer().getBranchId())
                        .accountNo(transferOrder.getTransfer().getAccountNo())
                        .build());
        fromAccount.subtractTotalAmount(
                transferOrder.getTransfer().getAmount()
                .add(transferOrder.getTransfer().getFee()));
        savingsAccountRepository.save(fromAccount);
        SavingsAccount toAccount = savingsAccountRepository.getOne(
                SavingsAccountPK.builder()
                        .financialCode(transferOrder.getTransfer().getTransferToFinancialCode())
                        .branchId(transferOrder.getTransfer().getTransferToBranchiId())
                        .accountNo(transferOrder.getTransfer().getTransferToAccountNo())
                        .build());
        toAccount.addTotalAmount(transferOrder.getTransfer().getAmount());
        savingsAccountRepository.save(toAccount);
    }

    @Override
    public Transfer recordTransfer(Transfer transfer) {
        if(Objects.isNull(transfer.getTradeId())){
            transfer.setTradeId(UUID.randomUUID().toString());
            transfer.setLastUpdatedAt(Timestamp.from(ZonedDateTime.now().toInstant()));
            transfer.setVer(0);
        }
        transfer.setTransactionStatus("COMPLETED");
        transferRepository.save(transfer);
        return transfer;
    }

}
