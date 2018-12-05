package org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.Objects;
import java.util.stream.Collectors;

import org.debugroom.mynavi.ib.monolithic.app.model.common.AccountType;
import org.debugroom.mynavi.ib.monolithic.app.AppConsts;

public interface SavingsAccountMapper {

    public static SavingsAccount createFromEntity(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount entity){
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

    public static org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount
        createEntity(SavingsAccount savingsAccount){
        org.debugroom.mynavi.ib.monolithic.domain.model.entity.
                SavingsAccount.SavingsAccountBuilder entityBuilder =
        org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount.builder();
        if(Objects.nonNull(savingsAccount.getUserId())){
            entityBuilder.userId(savingsAccount.getUserId());
        }
        if(Objects.nonNull(savingsAccount.getFinancialCode())){
            entityBuilder.financialCode(savingsAccount.getFinancialCode());
        }
        if(Objects.nonNull(savingsAccount.getBranchId())){
            entityBuilder.branchId(savingsAccount.getBranchId());
        }
        if(Objects.nonNull(savingsAccount.getCifNo())){
            entityBuilder.cifNo(savingsAccount.getCifNo());
        }
        if(Objects.nonNull(savingsAccount.getAccountNo())){
            entityBuilder.accountNo(savingsAccount.getAccountNo());
        }
        if(Objects.nonNull(savingsAccount.getAccountType())){
            entityBuilder.accountType(savingsAccount.getAccountType().toString());
        }
        if(Objects.nonNull(savingsAccount.getTotalAmount())){
            entityBuilder.totalAmount(savingsAccount.getTotalAmount().toBigInteger());
        }
        if(Objects.nonNull(savingsAccount.getAccountStartDate())){
            entityBuilder.accountStartDate(Timestamp.from(
                            savingsAccount.getAccountStartDate().toInstant()));
        }
        if(Objects.nonNull(savingsAccount.getLastUpdatedAt())){
            entityBuilder.lastUpdatedAt(Timestamp.from(
                            savingsAccount.getLastUpdatedAt().toInstant()));
        }
        return entityBuilder.build();
    }

}
