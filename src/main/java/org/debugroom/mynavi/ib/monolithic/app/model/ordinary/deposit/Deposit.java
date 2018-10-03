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
public class Deposit implements Serializable {

    private String tradeId;
    private String userId;
    private String financialCode;
    private String branchId;
    private String accountNo;
    private BigDecimal balance;
    private ZonedDateTime lastUpdatedAt;

}
