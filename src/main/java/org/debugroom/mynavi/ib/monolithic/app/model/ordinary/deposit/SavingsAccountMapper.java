package org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit;

import org.debugroom.mynavi.ib.monolithic.app.model.common.AccountType;
import org.debugroom.mynavi.ib.monolithic.app.model.common.AppConsts;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.stream.Collectors;

public interface SavingsAccountMapper {

    public static SavingsAccount createFromEntity(org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount entity){
        return SavingsAccount.builder()
                .userId(entity.getUserId())
                .financialCode(entity.getFinancialCode())
                .branchId(entity.getBranchId())
                .cifNo(entity.getCifNo())
                .accountNo(entity.getAccountNo())
                .accountType(AccountType.valueOf(entity.getAccountType()))
                .totalAmount(new BigDecimal(entity.getTotalAmount()))
                .accountStartDate(entity.getAccountStartDate()
                        .toLocalDateTime().atZone(
                                ZoneId.of(ZoneId.SHORT_IDS.get(
                                        AppConsts.TIMEZONE_SHORT_ID))))
                .lastUpdatedAt(entity.getLastUpdatedAt()
                        .toLocalDateTime().atZone(
                                ZoneId.of(ZoneId.SHORT_IDS.get(
                                        AppConsts.TIMEZONE_SHORT_ID))))
                .build();
    }

    public static SavingsAccount createFromEntityWithDeposits(org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount entity){
        SavingsAccount savingsAccount = createFromEntity(entity);
        savingsAccount.setDeposits(entity.getDeposits()
        .stream().map(DepositMapper::createFromEntity)
        .collect(Collectors.toList()));
        return savingsAccount;
    }

}
