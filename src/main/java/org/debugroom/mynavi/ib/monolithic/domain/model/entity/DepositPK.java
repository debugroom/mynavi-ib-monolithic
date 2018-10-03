package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DepositPK implements Serializable {
    private String tradeId;
    private String userId;
    private String financialCode;
    private String branchId;
    private String accountNo;

    @Column(name = "trade_id", nullable = false, length = 128)
    @Id
    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    @Column(name = "user_id", nullable = false, length = 8)
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "financial_code", nullable = false, length = 4)
    @Id
    public String getFinancialCode() {
        return financialCode;
    }

    public void setFinancialCode(String financialCode) {
        this.financialCode = financialCode;
    }

    @Column(name = "branch_id", nullable = false, length = 6)
    @Id
    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    @Column(name = "account_no", nullable = false, length = 7)
    @Id
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepositPK depositPK = (DepositPK) o;
        return Objects.equals(tradeId, depositPK.tradeId) &&
                Objects.equals(userId, depositPK.userId) &&
                Objects.equals(financialCode, depositPK.financialCode) &&
                Objects.equals(branchId, depositPK.branchId) &&
                Objects.equals(accountNo, depositPK.accountNo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tradeId, userId, financialCode, branchId, accountNo);
    }
}
