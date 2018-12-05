package org.debugroom.mynavi.ib.monolithic.app.model.foreign.currency.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.debugroom.mynavi.ib.monolithic.app.model.common.TransactionStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ForeignCurrencyDeposit implements Serializable {

    private String tradeId;
    private String userId;
    private String financialCode;
    private String branchId;
    private String accountNo;
    private String foreignCurrencyAccountNo;
    private BigDecimal balance;
    private LocalDateTime tradeStartDate;
    private String maturityDay;
    private BigDecimal ratio;
    private LocalDateTime lastUpdatedAt;
    private ForeginCurrencyDepositType foreginCurrencyDepositType;
    private ForeignCurrencyDepositAccount foreignCurrencyDepositAccount;
    private TransactionStatus transactionStatus;

}
