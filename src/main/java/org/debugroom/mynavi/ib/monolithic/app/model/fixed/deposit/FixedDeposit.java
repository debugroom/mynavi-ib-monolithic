package org.debugroom.mynavi.ib.monolithic.app.model.fixed.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.debugroom.mynavi.ib.monolithic.app.model.common.TransactionStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FixedDeposit implements Serializable {

    private String tradeId;
    private String userId;
    private String financialCode;
    private String branchId;
    private String accountNo;
    private String fixedAccountNo;
    private FixedDepositType fixedDepositType;
    private ZonedDateTime tradeStartDate;
    private String maturityDay;
    private BigDecimal balance;
    private BigDecimal ratio;
    private TransactionStatus transactionStatus;
    private ZonedDateTime lastUpdatedAt;
    private FixedDepositAccount fixedDepositAccount;

}
