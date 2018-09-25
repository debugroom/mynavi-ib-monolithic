package org.debugroom.mynavi.ib.monolithic.app.service.ordinary.deposit.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.debugroom.mynavi.ib.monolithic.apinfra.exception.BusinessException;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccount;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccountMapper;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.TransferOrder;
import org.debugroom.mynavi.ib.monolithic.app.service.ordinary.deposit.TransferService;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.SavingsAccountRepository;
import org.debugroom.mynavi.ib.monolithic.domain.component.ordinary.deposit.SavingsAccountManipulator;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccountPK;

@Service("transferService")
@Transactional
public class TransferServiceImpl implements TransferService {

    @Autowired
    SavingsAccountManipulator savingsAccountManipulator;

    @Autowired
    SavingsAccountRepository savingsAccountRepository;

    @Override
    public TransferOrder createTransferOrder(
            String transferToFinancialCode, String transferToBranchId,
            String transferToAccountNo, SavingsAccount transferFromSavingsAccount)
            throws BusinessException{
        if(!savingsAccountRepository.existsById(
                SavingsAccountPK.builder()
                        .financialCode(transferToFinancialCode)
                        .branchId(transferToBranchId)
                        .accountNo(transferToAccountNo)
                .build())){
            throw new BusinessException("error.ordinary.deposit.0001",
                    "Not found user which has finacode: [1], branch: [2], account: [3]",
                    transferToFinancialCode, transferToBranchId, transferToAccountNo);

        }
        return TransferOrder.builder()
                .financialCode(transferToFinancialCode)
                .branchId(transferToBranchId)
                .accountNo(transferToAccountNo)
                .savingsAccount(SavingsAccountMapper.createFromEntity(
                    savingsAccountRepository.getOne(
                        SavingsAccountPK.builder()
                        .userId(
                            transferFromSavingsAccount.getUserId())
                        .financialCode(
                            transferFromSavingsAccount.getFinancialCode())
                        .branchId(
                            transferFromSavingsAccount.getBranchId())
                        .accountNo(
                            transferFromSavingsAccount.getAccountNo())
                        .build()
                    )
                ))
                .build();
    }

    @Override
    public TransferOrder orderTransfer(TransferOrder transferOrder) {
        SavingsAccount transferFromAccount = SavingsAccountMapper.createFromEntity(savingsAccountRepository.getOne(
                SavingsAccountPK.builder()
                .userId(transferOrder.getSavingsAccount().getUserId())
                .financialCode(transferOrder.getSavingsAccount().getFinancialCode())
                .branchId(transferOrder.getSavingsAccount().getBranchId())
                .accountNo(transferOrder.getSavingsAccount().getAccountNo())
                .build()));

        return null;
    }

}
