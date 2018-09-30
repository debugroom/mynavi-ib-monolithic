package org.debugroom.mynavi.ib.monolithic.app.service.ordinary.deposit;

import org.debugroom.mynavi.ib.monolithic.apinfra.exception.BusinessException;
import org.debugroom.mynavi.ib.monolithic.app.model.common.User;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccount;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.TransferOrder;

import java.math.BigDecimal;

public interface TransferService {

    public TransferOrder createTransferOrder(
            String transferToFinancialCode, String transferToBranchId,
            String transferToAccountNo, SavingsAccount transferFromSavingsAccount)
        throws BusinessException;
    public TransferOrder confirmTransferPermission(
            TransferOrder transferOrder, User user)
        throws BusinessException;
    public TransferOrder orderTransfer(TransferOrder transferOrder) throws BusinessException;

}
