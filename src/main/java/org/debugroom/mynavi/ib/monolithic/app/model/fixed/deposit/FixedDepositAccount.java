package org.debugroom.mynavi.ib.monolithic.app.model.fixed.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.debugroom.mynavi.ib.monolithic.app.model.common.AccountType;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccount;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FixedDepositAccount implements Serializable {

    private String userId;
    private String financialCode;
    private String branchId;
    private String accountNo;
    private String cifNo;
    private String fixedAccountNo;
    private AccountType accountType;
    private ZonedDateTime accountStartDate;
    private ZonedDateTime lastUpdatedAt;
    List<FixedDeposit> fixedDeposits;
    private SavingsAccount savingsAccount;

}
