package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ForeignCurrencyDepositAccountPK implements Serializable {
    private String userId;
    private String financialCode;
    private String branchId;
    private String accountNo;
    private String foreignCurrencyAccountNo;

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

    @Column(name = "foreign_currency_account_no", nullable = false, length = 7)
    @Id
    public String getForeignCurrencyAccountNo() {
        return foreignCurrencyAccountNo;
    }

    public void setForeignCurrencyAccountNo(String foreignCurrencyAccountNo) {
        this.foreignCurrencyAccountNo = foreignCurrencyAccountNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForeignCurrencyDepositAccountPK that = (ForeignCurrencyDepositAccountPK) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(financialCode, that.financialCode) &&
                Objects.equals(branchId, that.branchId) &&
                Objects.equals(accountNo, that.accountNo) &&
                Objects.equals(foreignCurrencyAccountNo, that.foreignCurrencyAccountNo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, financialCode, branchId, accountNo, foreignCurrencyAccountNo);
    }
}
