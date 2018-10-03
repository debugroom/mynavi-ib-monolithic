package org.debugroom.mynavi.ib.monolithic.app.service.ordinary.deposit.impl;

import java.util.Optional;

import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.TransferMapper;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.debugroom.mynavi.ib.monolithic.apinfra.exception.BusinessException;
import org.debugroom.mynavi.ib.monolithic.app.AppProperties;
import org.debugroom.mynavi.ib.monolithic.app.model.common.Credential;
import org.debugroom.mynavi.ib.monolithic.app.model.common.User;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccount;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccountMapper;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.TransferOrder;
import org.debugroom.mynavi.ib.monolithic.app.service.common.CredentialService;
import org.debugroom.mynavi.ib.monolithic.app.service.ordinary.deposit.TransferService;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.SavingsAccountRepository;
import org.debugroom.mynavi.ib.monolithic.domain.component.ordinary.deposit.SavingsAccountManipulator;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccountPK;

@Service("transferService")
@Transactional
public class TransferServiceImpl implements TransferService {

    @Autowired
    AppProperties properties;

    @Autowired
    CredentialService credentialService;

    @Autowired
    SavingsAccountManipulator savingsAccountManipulator;

    @Autowired
    SavingsAccountRepository savingsAccountRepository;

    @Autowired
    TransferRepository transferRepository;

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
                .transferToFinancialCode(transferToFinancialCode)
                .transferToBranchId(transferToBranchId)
                .transferToAccountNo(transferToAccountNo)
                .transferFromSavingsAccount(SavingsAccountMapper.createFromEntity(
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
    public TransferOrder confirmTransferPermission(
            TransferOrder transferOrder, User user) throws BusinessException {
        Optional<Credential> secondaryPasswordCredential = user.getCredentials().stream()
                .filter(credential ->
                        properties.getCredentialSecondaryPasswordLogicalName()
                                .equals(credential.getCredentialKeyType()))
                .findFirst();
        if(credentialService.authorizeBy(
                secondaryPasswordCredential.get().getCredentialKey(), user)){
            throw new BusinessException("error.ordinary.deposit.0003",
                    "Invalid User ID or password. userId:", user.getUserId());
        }

        SavingsAccount transferFromAccount = SavingsAccountMapper.createFromEntity(
            savingsAccountRepository.getOne(
                SavingsAccountPK.builder()
                    .userId(transferOrder.getTransferFromSavingsAccount().getUserId())
                    .financialCode(transferOrder.getTransferFromSavingsAccount().getFinancialCode())
                    .branchId(transferOrder.getTransferFromSavingsAccount().getBranchId())
                    .accountNo(transferOrder.getTransferFromSavingsAccount().getAccountNo())
                    .build()));
        if(transferFromAccount.getTotalAmount().compareTo(
                transferOrder.getAmount().add(transferOrder.getFee())) < 0){
            throw new BusinessException("error.ordinary.deposit.0002",
                    "Insufficient balance for transfer order in finacode: [1], branch: [2], account: [3]",
                    transferFromAccount.getFinancialCode(), transferFromAccount.getBranchId(),
                    transferFromAccount.getAccountNo());
        }
        return transferOrder;
    }

    @Override
    public TransferOrder orderTransfer(TransferOrder transferOrder) throws BusinessException{

        SavingsAccount transferFromAccount = SavingsAccountMapper.createFromEntity(
                savingsAccountRepository.getOne(
                SavingsAccountPK.builder()
                .userId(transferOrder.getTransferFromSavingsAccount().getUserId())
                .financialCode(transferOrder.getTransferFromSavingsAccount().getFinancialCode())
                .branchId(transferOrder.getTransferFromSavingsAccount().getBranchId())
                .accountNo(transferOrder.getTransferFromSavingsAccount().getAccountNo())
                .build()));

        SavingsAccount transferToAccount = SavingsAccountMapper.createFromEntity(
                savingsAccountRepository.getOne(
                SavingsAccountPK.builder()
                .userId(transferOrder.getTransferToUserId())
                .financialCode(transferOrder.getTransferToFinancialCode())
                .branchId(transferOrder.getTransferToBranchId())
                .accountNo(transferOrder.getTransferToAccountNo())
                .build()));

        savingsAccountManipulator.subtractTotalAmountOf(
            SavingsAccountMapper.createEntity(transferFromAccount),
            transferOrder.getAmount().add(transferOrder.getFee()));

        savingsAccountManipulator.addTotalAmountOf(
            SavingsAccountMapper.createEntity(SavingsAccount.builder()
                .userId(transferOrder.getTransferToUserId())
                .financialCode(transferOrder.getTransferToFinancialCode())
                .branchId(transferOrder.getTransferToBranchId())
                .accountNo(transferOrder.getTransferToAccountNo())
                .build()), transferOrder.getAmount());

        transferRepository.save(TransferMapper.createEntitty(transferOrder));

        return transferOrder;

    }

}
