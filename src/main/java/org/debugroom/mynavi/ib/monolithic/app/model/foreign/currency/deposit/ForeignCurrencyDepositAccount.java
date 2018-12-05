package org.debugroom.mynavi.ib.monolithic.app.model.foreign.currency.deposit;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Currency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.debugroom.mynavi.ib.monolithic.app.model.common.AccountType;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ForeignCurrencyDepositAccount implements Serializable {

    private String userId;
    private String financialCode;
    private String branchId;
    private String accountNo;
    private String cifNo;
    private String foreignCurrencyAccountNo;
    private AccountType accountType;
    private Currency currency;
    private ZonedDateTime accountStartDate;
    private ZonedDateTime lastUpdatedAt;

}
