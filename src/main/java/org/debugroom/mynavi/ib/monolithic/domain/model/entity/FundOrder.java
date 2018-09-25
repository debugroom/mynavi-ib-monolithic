package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "fund_order", schema = "public", catalog = "mynavi_ib")
@IdClass(FundOrderPK.class)
public class FundOrder {
    private String tradeId;
    private String userId;
    private String financialCode;
    private String branchId;
    private String accountNo;
    private String fundAccountNo;
    private String fundId;
    private BigInteger amount;
    private Timestamp tradeStartDate;
    private Timestamp lastUpdatedAt;
    private FundAccount fundAccount;
    private Fund fundByFundId;

    @Id
    @Column(name = "trade_id", nullable = false, length = 128)
    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    @Id
    @Column(name = "user_id", nullable = false, length = 8)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "financial_code", nullable = false, length = 4)
    public String getFinancialCode() {
        return financialCode;
    }

    public void setFinancialCode(String financialCode) {
        this.financialCode = financialCode;
    }

    @Id
    @Column(name = "branch_id", nullable = false, length = 6)
    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    @Id
    @Column(name = "account_no", nullable = false, length = 7)
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Id
    @Column(name = "fund_account_no", nullable = false, length = 7)
    public String getFundAccountNo() {
        return fundAccountNo;
    }

    public void setFundAccountNo(String fundAccountNo) {
        this.fundAccountNo = fundAccountNo;
    }

    @Id
    @Column(name = "fund_id", nullable = false, length = 8)
    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    @Basic
    @Column(name = "amount", nullable = true, precision = 0)
    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "trade_start_date", nullable = true)
    public Timestamp getTradeStartDate() {
        return tradeStartDate;
    }

    public void setTradeStartDate(Timestamp tradeStartDate) {
        this.tradeStartDate = tradeStartDate;
    }

    @Basic
    @Column(name = "last_updated_at", nullable = true)
    public Timestamp getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FundOrder fundOrder = (FundOrder) o;
        return Objects.equals(tradeId, fundOrder.tradeId) &&
                Objects.equals(userId, fundOrder.userId) &&
                Objects.equals(financialCode, fundOrder.financialCode) &&
                Objects.equals(branchId, fundOrder.branchId) &&
                Objects.equals(accountNo, fundOrder.accountNo) &&
                Objects.equals(fundAccountNo, fundOrder.fundAccountNo) &&
                Objects.equals(fundId, fundOrder.fundId) &&
                Objects.equals(amount, fundOrder.amount) &&
                Objects.equals(tradeStartDate, fundOrder.tradeStartDate) &&
                Objects.equals(lastUpdatedAt, fundOrder.lastUpdatedAt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tradeId, userId, financialCode, branchId, accountNo, fundAccountNo, fundId, amount, tradeStartDate, lastUpdatedAt);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false), @JoinColumn(name = "financial_code", referencedColumnName = "financial_code", nullable = false), @JoinColumn(name = "branch_id", referencedColumnName = "branch_id", nullable = false), @JoinColumn(name = "account_no", referencedColumnName = "account_no", nullable = false), @JoinColumn(name = "fund_account_no", referencedColumnName = "fund_account_no", nullable = false)})
    public FundAccount getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(FundAccount fundAccount) {
        this.fundAccount = fundAccount;
    }

    @ManyToOne
    @JoinColumn(name = "fund_id", referencedColumnName = "fund_id", nullable = false)
    public Fund getFundByFundId() {
        return fundByFundId;
    }

    public void setFundByFundId(Fund fundByFundId) {
        this.fundByFundId = fundByFundId;
    }
}
