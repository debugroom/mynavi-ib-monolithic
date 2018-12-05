package org.debugroom.mynavi.ib.monolithic.app.model.fixed.deposit;

import org.debugroom.mynavi.ib.monolithic.app.AppConsts;
import org.debugroom.mynavi.ib.monolithic.app.model.common.TransactionStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.Objects;

public interface FixedDepositMapper {

    public static org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDeposit
        createEntity(FixedDeposit fixedDeposit){
        org.debugroom.mynavi.ib.monolithic.domain.model.entity.
                FixedDeposit.FixedDepositBuilder entityBuilder =
        org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDeposit.builder();
        if(Objects.nonNull(fixedDeposit.getTradeId())){
            entityBuilder.tradeId(fixedDeposit.getTradeId());
        }
        if(Objects.nonNull(fixedDeposit.getUserId())){
            entityBuilder.userId(fixedDeposit.getUserId());
        }
        if(Objects.nonNull(fixedDeposit.getFinancialCode())){
            entityBuilder.financialCode(fixedDeposit.getFinancialCode());
        }
        if(Objects.nonNull(fixedDeposit.getBranchId())){
            entityBuilder.branchId(fixedDeposit.getBranchId());
        }
        if(Objects.nonNull(fixedDeposit.getAccountNo())){
            entityBuilder.accountNo(fixedDeposit.getAccountNo());
        }
        if(Objects.nonNull(fixedDeposit.getFixedAccountNo())){
            entityBuilder.fixedAccountNo(fixedDeposit.getFixedAccountNo());
        }
        if(Objects.nonNull(fixedDeposit.getFixedDepositType())){
            entityBuilder.fixedAccountNo(fixedDeposit.getFixedDepositType().toString());
        }
        if(Objects.nonNull(fixedDeposit.getTradeStartDate())){
            entityBuilder.tradeStartDate(Timestamp.from(
                    fixedDeposit.getTradeStartDate().toInstant()));
        }
        if(Objects.nonNull(fixedDeposit.getMaturityDay())){
            entityBuilder.maturityDay(fixedDeposit.getMaturityDay());
        }
        if(Objects.nonNull(fixedDeposit.getBalance())){
            entityBuilder.balance(fixedDeposit.getBalance().toBigInteger());
        }
        if(Objects.nonNull(fixedDeposit.getRatio())){
            entityBuilder.ratio(fixedDeposit.getRatio().toBigInteger());
        }
        if(Objects.nonNull(fixedDeposit.getTransactionStatus())){
            entityBuilder.transactionStatus(fixedDeposit.getTransactionStatus().toString());
        }
        if(Objects.nonNull(fixedDeposit.getLastUpdatedAt())){
            entityBuilder.lastUpdatedAt(Timestamp.from(
                    fixedDeposit.getLastUpdatedAt().toInstant()));
        }
        return entityBuilder.build();
    }

    public static FixedDeposit createFromEntity(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDeposit entity){
        return FixedDeposit.builder()
                .tradeId(entity.getTradeId())
                .userId(entity.getUserId())
                .financialCode(entity.getFinancialCode())
                .branchId(entity.getBranchId())
                .accountNo(entity.getAccountNo())
                .fixedAccountNo(entity.getFixedAccountNo())
                .fixedDepositType(FixedDepositType.valueOf(entity.getFixedDepositType()))
                .tradeStartDate(entity.getTradeStartDate().toLocalDateTime().atZone(
                        ZoneId.of(ZoneId.SHORT_IDS.get(AppConsts.TIMEZONE_SHORT_ID))))
                .maturityDay(entity.getMaturityDay())
                .balance(new BigDecimal(entity.getBalance()))
                .ratio(new BigDecimal(entity.getRatio()))
                .transactionStatus(TransactionStatus.valueOf(entity.getTransactionStatus()))
                .lastUpdatedAt(entity.getLastUpdatedAt().toLocalDateTime().atZone(
                        ZoneId.of(ZoneId.SHORT_IDS.get(AppConsts.TIMEZONE_SHORT_ID))))
                .build();
    }

    public static FixedDeposit createFromEntityWithFixedDepositAccount(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDeposit entity){
        FixedDeposit fixedDeposit = createFromEntity(entity);
        fixedDeposit.setFixedDepositAccount(
                FixedDepositAccountMapper.createFromEntityWithSavingsAccount(entity.getFixedDepositAccount()));
        return fixedDeposit;
    }

}
