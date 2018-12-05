package org.debugroom.mynavi.ib.monolithic.app.model.fixed.deposit;

import org.debugroom.mynavi.ib.monolithic.app.AppConsts;
import org.debugroom.mynavi.ib.monolithic.app.model.common.AccountType;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccountMapper;

import java.time.ZoneId;

public interface FixedDepositAccountMapper {

    public static FixedDepositAccount createFromEntity(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDepositAccount entity){
       return FixedDepositAccount.builder()
               .userId(entity.getUserId())
               .financialCode(entity.getFinancialCode())
               .branchId(entity.getBranchId())
               .accountNo(entity.getAccountNo())
               .cifNo(entity.getCifNo())
               .fixedAccountNo(entity.getFixedAccountNo())
               .accountType(AccountType.valueOf(entity.getAccountType()))
               .accountStartDate(entity.getAccountStartDate().toLocalDateTime().atZone(
                       ZoneId.of(ZoneId.SHORT_IDS.get(AppConsts.TIMEZONE_SHORT_ID))))
               .lastUpdatedAt(entity.getLastUpdatedAt().toLocalDateTime().atZone(
                       ZoneId.of(ZoneId.SHORT_IDS.get(AppConsts.TIMEZONE_SHORT_ID))))
               .build();
    }

    public static FixedDepositAccount createFromEntityWithSavingsAccount(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDepositAccount entity) {
        FixedDepositAccount fixedDepositAccount = createFromEntity(entity);
        fixedDepositAccount.setSavingsAccount(
                SavingsAccountMapper.createFromEntity(entity.getSavingsAccount()));
        return fixedDepositAccount;
    }

}
