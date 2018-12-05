package org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit;

import org.debugroom.mynavi.ib.monolithic.apinfra.exception.BusinessException;
import org.debugroom.mynavi.ib.monolithic.app.AppConsts;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.Objects;

public interface TransferMapper {

    public static org.debugroom.mynavi.ib.monolithic.domain.model.entity.Transfer
        createEntitty(TransferOrder transferOrder){
        org.debugroom.mynavi.ib.monolithic.domain.model.entity
                .Transfer.TransferBuilder entityBuilder =
                org.debugroom.mynavi.ib.monolithic.domain.model.entity.Transfer.builder();
        SavingsAccount transferFromSavingAccount =
                transferOrder.getTransferFromSavingsAccount();
        if(Objects.nonNull(transferFromSavingAccount)){
            if(Objects.nonNull(transferFromSavingAccount.getUserId())){
                entityBuilder.userId(transferFromSavingAccount.getUserId());
            }
            if(Objects.nonNull(transferFromSavingAccount.getFinancialCode())){
                entityBuilder.financialCode(transferFromSavingAccount.getFinancialCode());
            }
            if(Objects.nonNull(transferFromSavingAccount.getBranchId())){
                entityBuilder.branchId(transferFromSavingAccount.getBranchId());
            }
            if(Objects.nonNull(transferFromSavingAccount.getAccountNo())){
                entityBuilder.accountNo(transferFromSavingAccount.getAccountNo());
            }
        }
        if(Objects.nonNull(transferOrder.getTransferToFinancialCode())){
            entityBuilder.transferToFinancialCode(transferOrder.getTransferToFinancialCode());
        }
        if(Objects.nonNull(transferOrder.getTransferToBranchId())){
            entityBuilder.transferToBranchiId(transferOrder.getTransferToBranchId());
        }
        if(Objects.nonNull(transferOrder.getTransferToAccountNo())){
            entityBuilder.transferToAccountNo(transferOrder.getTransferToAccountNo());
        }
        if(Objects.nonNull(transferOrder.getAmount())){
            entityBuilder.amount(transferOrder.getAmount().toBigInteger());
        }
        if(Objects.nonNull(transferOrder.getTransferTradeDay())){
            entityBuilder.transferTradeDay(transferOrder.getTransferTradeDay());
        }
        if(Objects.nonNull(transferOrder.getFee())){
            entityBuilder.fee(transferOrder.getFee().toBigInteger());
        }
        if(Objects.nonNull(transferOrder.getLastUpdatedAt())){
            entityBuilder.lastUpdatedAt(Timestamp.from(
                    transferOrder.getLastUpdatedAt().toInstant()));
        }

        return entityBuilder.build();
    }

    public static org.debugroom.mynavi.ib.monolithic.domain.model.ordinary.deposit.TransferOrder
        map(TransferOrder transferOrder){
        org.debugroom.mynavi.ib.monolithic.domain.model.entity.Transfer.TransferBuilder entityBuilder =
                org.debugroom.mynavi.ib.monolithic.domain.model.entity.Transfer.builder();
        SavingsAccount transferFromSavingAccount =
                transferOrder.getTransferFromSavingsAccount();
        if(Objects.nonNull(transferFromSavingAccount)){
            if(Objects.nonNull(transferFromSavingAccount.getUserId())){
                entityBuilder.userId(transferFromSavingAccount.getUserId());
            }
            if(Objects.nonNull(transferFromSavingAccount.getFinancialCode())){
                entityBuilder.financialCode(transferFromSavingAccount.getFinancialCode());
            }
            if(Objects.nonNull(transferFromSavingAccount.getBranchId())){
                entityBuilder.branchId(transferFromSavingAccount.getBranchId());
            }
            if(Objects.nonNull(transferFromSavingAccount.getAccountNo())){
                entityBuilder.accountNo(transferFromSavingAccount.getAccountNo());
            }
        }
        if(Objects.nonNull(transferOrder.getTransferToFinancialCode())){
            entityBuilder.transferToFinancialCode(transferOrder.getTransferToFinancialCode());
        }
        if(Objects.nonNull(transferOrder.getTransferToBranchId())){
            entityBuilder.transferToBranchiId(transferOrder.getTransferToBranchId());
        }
        if(Objects.nonNull(transferOrder.getTransferToAccountNo())){
            entityBuilder.transferToAccountNo(transferOrder.getTransferToAccountNo());
        }
        if(Objects.nonNull(transferOrder.getAmount())){
            entityBuilder.amount(transferOrder.getAmount().toBigInteger());
        }
        if(Objects.nonNull(transferOrder.getTransferTradeDay())){
            entityBuilder.transferTradeDay(transferOrder.getTransferTradeDay());
        }
        if(Objects.nonNull(transferOrder.getFee())){
            entityBuilder.fee(transferOrder.getFee().toBigInteger());
        }

        return org.debugroom.mynavi.ib.monolithic.domain.model.ordinary.deposit.TransferOrder
                .builder().transfer(entityBuilder.build()).build();
    }

    public static TransferOrder createFromEntity(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.Transfer entity)
            throws BusinessException{
        return TransferOrder.builder()
                .tradeId(entity.getTradeId())
                .transferToFinancialCode(entity.getTransferToFinancialCode())
                .transferToBranchId(entity.getTransferToBranchiId())
                .transferToAccountNo(entity.getTransferToAccountNo())
                .amount(new BigDecimal(entity.getAmount()))
                .transferTradeDay(entity.getTransferTradeDay())
                .fee(new BigDecimal(entity.getFee()))
                .lastUpdatedAt(entity.getLastUpdatedAt()
                        .toLocalDateTime().atZone(
                                ZoneId.of(ZoneId.SHORT_IDS.get(
                                        AppConsts.TIMEZONE_SHORT_ID))))
                .transferFromSavingsAccount(SavingsAccountMapper.createFromEntity(
                        entity.getSavingsAccount()))
                .build();
    }

}
