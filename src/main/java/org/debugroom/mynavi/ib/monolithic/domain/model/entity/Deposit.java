package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(DepositPK.class)
public class Deposit {
    private String tradeId;
    private String userId;
    private String financialCode;
    private String branchId;
    private String accountNo;
    private BigInteger balance;
    private Timestamp lastUpdatedAt;
    private Integer ver;
    private SavingsAccount savingsAccount;

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

    @Basic
    @Column(name = "balance", nullable = true, precision = 0)
    public BigInteger getBalance() {
        return balance;
    }

    public void setBalance(BigInteger balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "last_updated_at", nullable = true)
    public Timestamp getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    @Basic
    @Column(name = "ver", nullable = true)
    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return Objects.equals(tradeId, deposit.tradeId) &&
                Objects.equals(userId, deposit.userId) &&
                Objects.equals(financialCode, deposit.financialCode) &&
                Objects.equals(branchId, deposit.branchId) &&
                Objects.equals(accountNo, deposit.accountNo) &&
                Objects.equals(balance, deposit.balance) &&
                Objects.equals(lastUpdatedAt, deposit.lastUpdatedAt) &&
                Objects.equals(ver, deposit.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tradeId, userId, financialCode, branchId, accountNo, balance, lastUpdatedAt, ver);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false), @JoinColumn(name = "financial_code", referencedColumnName = "financial_code", nullable = false), @JoinColumn(name = "branch_id", referencedColumnName = "branch_id", nullable = false), @JoinColumn(name = "account_no", referencedColumnName = "account_no", nullable = false)})
    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }
}
