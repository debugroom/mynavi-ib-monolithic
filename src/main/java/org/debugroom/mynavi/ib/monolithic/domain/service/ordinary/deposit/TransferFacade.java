package org.debugroom.mynavi.ib.monolithic.domain.service.ordinary.deposit;

import org.debugroom.mynavi.ib.monolithic.apinfra.exception.BusinessException;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.Transfer;
import org.debugroom.mynavi.ib.monolithic.domain.model.ordinary.deposit.TransferOrder;

import java.math.BigDecimal;

public interface TransferFacade {

    public SavingsAccount inquirySavingAccount(
            String userId, String financialCode, String branchId, String accountNo);
    public void transfer(TransferOrder transferOrder) throws BusinessException;
    public Transfer reserveTransfer(Transfer transfer);
    public Transfer recordTransfer(Transfer transfer);
    public boolean canTransfer(Transfer transfer);
    public BigDecimal getFee(Transfer transfer);
    public boolean existsTransferToSavingsAccount(SavingsAccount savingsAccount);

}
