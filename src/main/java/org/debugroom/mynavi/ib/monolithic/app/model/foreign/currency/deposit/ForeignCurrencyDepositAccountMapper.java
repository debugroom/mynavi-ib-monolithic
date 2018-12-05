package org.debugroom.mynavi.ib.monolithic.app.model.foreign.currency.deposit;

import org.debugroom.mynavi.ib.monolithic.app.AppConsts;
import org.debugroom.mynavi.ib.monolithic.app.model.common.AccountType;

import java.time.ZoneId;
import java.util.Currency;

public interface ForeignCurrencyDepositAccountMapper {

    public static ForeignCurrencyDepositAccount createFromEntity(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.ForeignCurrencyDepositAccount entity){
        return ForeignCurrencyDepositAccount.builder()
                .userId(entity.getUserId())
                .financialCode(entity.getFinancialCode())
                .branchId(entity.getBranchId())
                .accountNo(entity.getAccountNo())
                .cifNo(entity.getCifNo())
                .foreignCurrencyAccountNo(entity.getForeignCurrencyAccountNo())
                .accountType(AccountType.valueOf(entity.getAccountType()))
                .accountStartDate(entity.getAccountStartDate().toLocalDateTime().atZone(
                        ZoneId.of(ZoneId.SHORT_IDS.get(AppConsts.TIMEZONE_SHORT_ID))))
                .currency(Currency.getInstance(AppConsts.CURRENCY_LOCALE))
                .lastUpdatedAt(entity.getLastUpdatedAt().toLocalDateTime().atZone(
                        ZoneId.of(ZoneId.SHORT_IDS.get(AppConsts.TIMEZONE_SHORT_ID))))
                .build();
    }

}
