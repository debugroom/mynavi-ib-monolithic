package org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TransferOrder implements Serializable {

    private String tradeId;
    private String userId;
    private String financialCode;
    private String branchId;
    private String accountNo;
    private BigDecimal amount;
    private String transferTradeDay;
    private BigDecimal fee;
    private ZonedDateTime lastUpdatedAt;
    private SavingsAccount savingsAccount;

}
