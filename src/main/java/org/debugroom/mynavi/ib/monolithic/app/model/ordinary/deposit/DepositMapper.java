package org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit;

import java.math.BigDecimal;
import java.time.ZoneId;

import org.debugroom.mynavi.ib.monolithic.app.AppConsts;
import org.debugroom.mynavi.ib.monolithic.app.model.common.Status;
import org.debugroom.mynavi.ib.monolithic.app.model.common.TransactionStatus;

public interface DepositMapper {

    public static Deposit createFromEntity(org.debugroom.mynavi.ib.monolithic.domain.model.entity.Deposit entity){
        return Deposit.builder()
                .tradeId(entity.getTradeId())
                .userId(entity.getUserId())
                .financialCode(entity.getFinancialCode())
                .branchId(entity.getBranchId())
                .accountNo(entity.getAccountNo())
                .balance(new BigDecimal(entity.getBalance()))
                .transactionStatus(TransactionStatus.valueOf(entity.getTransactionStatus()))
                .lastUpdatedAt(entity.getLastUpdatedAt()
                        .toLocalDateTime().atZone(
                                ZoneId.of(ZoneId.SHORT_IDS.get(
                                        AppConsts.TIMEZONE_SHORT_ID))))
                .build();
    }

}
