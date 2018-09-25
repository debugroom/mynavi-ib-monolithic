package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FundOrderPK implements Serializable {
    private String tradeId;
    private String userId;
    private String financialCode;
    private String branchId;
    private String accountNo;
    private String fundAccountNo;
    private String fundId;

    @Column(name = "trade_id", nullable = false, length = 128)
    @Id
    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    @Column(name = "user_id", nullable = false, insertable = false, updatable = false,  length = 8)
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "financial_code", nullable = false, insertable = false, updatable = false,  length = 4)
    @Id
    public String getFinancialCode() {
        return financialCode;
    }

    public void setFinancialCode(String financialCode) {
        this.financialCode = financialCode;
    }

    @Column(name = "branch_id", nullable = false, insertable = false, updatable = false,  length = 6)
    @Id
    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    @Column(name = "account_no", nullable = false, insertable = false, updatable = false,  length = 7)
    @Id
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Column(name = "fund_account_no", nullable = false, insertable = false, updatable = false,  length = 7)
    @Id
    public String getFundAccountNo() {
        return fundAccountNo;
    }

    public void setFundAccountNo(String fundAccountNo) {
        this.fundAccountNo = fundAccountNo;
    }

    @Column(name = "fund_id", nullable = false, insertable = false, updatable = false,  length = 8)
    @Id
    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FundOrderPK that = (FundOrderPK) o;
        return Objects.equals(tradeId, that.tradeId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(financialCode, that.financialCode) &&
                Objects.equals(branchId, that.branchId) &&
                Objects.equals(accountNo, that.accountNo) &&
                Objects.equals(fundAccountNo, that.fundAccountNo) &&
                Objects.equals(fundId, that.fundId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tradeId, userId, financialCode, branchId, accountNo, fundAccountNo, fundId);
    }
}
