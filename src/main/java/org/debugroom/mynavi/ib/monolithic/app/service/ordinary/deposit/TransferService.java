package org.debugroom.mynavi.ib.monolithic.app.service.ordinary.deposit;

import org.debugroom.mynavi.ib.monolithic.apinfra.exception.BusinessException;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccount;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.TransferOrder;

public interface TransferService {

    public TransferOrder createTransferOrder(
            String transferToFinancialCode, String transferToBranchId,
            String transferToAccountNo, SavingsAccount transferFromSavingsAccount)
            throws BusinessException;
    public TransferOrder orderTransfer(TransferOrder transferOrder);

}
