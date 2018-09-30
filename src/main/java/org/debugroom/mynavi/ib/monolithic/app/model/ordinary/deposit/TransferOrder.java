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
    private String transferToUserId;
    private String transferToFinancialCode;
    private String transferToBranchId;
    private String transferToAccountNo;
    private BigDecimal amount;
    private String transferTradeDay;
    private BigDecimal fee;
    private ZonedDateTime lastUpdatedAt;
    private SavingsAccount transferFromSavingsAccount;

}
