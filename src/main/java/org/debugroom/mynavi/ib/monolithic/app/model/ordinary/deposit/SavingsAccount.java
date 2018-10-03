package org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import org.debugroom.mynavi.ib.monolithic.app.model.common.AccountType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class SavingsAccount implements Serializable {

    private String userId;
    private String financialCode;
    private String branchId;
    private String cifNo;
    private String accountNo;
    private AccountType accountType;
    private BigDecimal totalAmount;
    private ZonedDateTime accountStartDate;
    private ZonedDateTime lastUpdatedAt;
    private List<Deposit> deposits;

    public static SavingsAccount createByEntity(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount entity){
        return SavingsAccountMapper.createFromEntity(entity);
    }

}
