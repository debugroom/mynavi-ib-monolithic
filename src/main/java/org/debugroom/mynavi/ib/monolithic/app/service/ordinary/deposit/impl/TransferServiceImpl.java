package org.debugroom.mynavi.ib.monolithic.app.service.ordinary.deposit.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.debugroom.mynavi.ib.monolithic.apinfra.util.DateUtil;
import org.debugroom.mynavi.ib.monolithic.apinfra.exception.BusinessException;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.TransferMapper;
import org.debugroom.mynavi.ib.monolithic.app.model.common.User;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccount;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccountMapper;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.TransferOrder;
import org.debugroom.mynavi.ib.monolithic.app.service.common.CredentialService;
import org.debugroom.mynavi.ib.monolithic.app.service.ordinary.deposit.TransferService;
import org.debugroom.mynavi.ib.monolithic.domain.service.ordinary.deposit.TransferFacade;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.UserRepository;

@Service("transferService")
@Transactional
public class TransferServiceImpl implements TransferService {

    @Autowired
    CredentialService credentialService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransferFacade transferFacade;

    @Override
    public TransferOrder createTransferOrder(
            String transferToFinancialCode, String transferToBranchId,
            String transferToAccountNo, SavingsAccount transferFromSavingsAccount)
            throws BusinessException{
        if(!transferFacade.existsTransferToSavingsAccount(
                SavingsAccountMapper.createEntity(SavingsAccount.builder()
                        .financialCode(transferToFinancialCode)
                        .branchId(transferToBranchId)
                        .accountNo(transferToAccountNo)
                        .build()))){
            throw new BusinessException("error.ordinary.deposit.0001",
                    "Not found user which has finacode: [1], branch: [2], account: [3]",
                    transferToFinancialCode, transferToBranchId, transferToAccountNo);

        }
        return TransferOrder.builder()
                .transferToFinancialCode(transferToFinancialCode)
                .transferToBranchId(transferToBranchId)
                .transferToAccountNo(transferToAccountNo)
                .transferFromSavingsAccount(SavingsAccountMapper.createFromEntity(
                   transferFacade.inquirySavingAccount(
                           transferFromSavingsAccount.getUserId(),
                           transferFromSavingsAccount.getFinancialCode(),
                           transferFromSavingsAccount.getBranchId(),
                           transferToAccountNo)))
                .build();
    }

    @Override
    public TransferOrder confirmTransferPermission(
            TransferOrder transferOrder, User user) throws BusinessException {
        if(!credentialService.authorizeBy(userRepository.getOne(user.getUserId())
                .findSecondaryPassword().getCredentialKey(), user)){
            throw new BusinessException("error.ordinary.deposit.0003",
                    "Invalid User ID or password. userId:", user.getUserId());
        }

        if(transferFacade.canTransfer(TransferMapper.createEntitty(transferOrder))){
            throw new BusinessException("error.ordinary.deposit.0002",
                    "Insufficient balance for transfer order in finacode: [1], branch: [2], account: [3]",
                    transferOrder.getTransferFromSavingsAccount().getFinancialCode(),
                    transferOrder.getTransferFromSavingsAccount().getBranchId(),
                    transferOrder.getTransferFromSavingsAccount().getAccountNo());
        }
        return transferOrder;
    }

    @Override
    public TransferOrder orderTransfer(TransferOrder transferOrder)
            throws BusinessException{

        if (!DateUtil.getCurrentDay().equals(transferOrder.getTransferTradeDay())) {
            return TransferMapper.createFromEntity(
                    transferFacade.reserveTransfer(
                            TransferMapper.createEntitty(transferOrder)));
        }

        transferFacade.transfer(TransferMapper.map(transferOrder));
        return TransferMapper.createFromEntity(
                transferFacade.recordTransfer(
                        TransferMapper.createEntitty(transferOrder)));
    }

}
