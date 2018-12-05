package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "fixed_deposit", schema = "public", catalog = "mynavi_ib")
@IdClass(FixedDepositPK.class)
public class FixedDeposit {
    private String tradeId;
    private String userId;
    private String financialCode;
    private String branchId;
    private String accountNo;
    private String fixedAccountNo;
    private Timestamp tradeStartDate;
    private String maturityDay;
    private BigInteger balance;
    private BigInteger ratio;
    private Timestamp lastUpdatedAt;
    private Integer ver;
    private FixedDepositAccount fixedDepositAccount;
    private String fixedDepositType;
    private String transactionStatus;

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
    @Column(name = "fixed_account_no", nullable = false, length = 7)
    public String getFixedAccountNo() {
        return fixedAccountNo;
    }

    public void setFixedAccountNo(String fixedAccountNo) {
        this.fixedAccountNo = fixedAccountNo;
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
    @Column(name = "maturity_day", nullable = true, length = 8)
    public String getMaturityDay() {
        return maturityDay;
    }

    public void setMaturityDay(String maturityDay) {
        this.maturityDay = maturityDay;
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
    @Column(name = "ratio", nullable = true, precision = 0)
    public BigInteger getRatio() {
        return ratio;
    }

    public void setRatio(BigInteger ratio) {
        this.ratio = ratio;
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
        FixedDeposit that = (FixedDeposit) o;
        return Objects.equals(tradeId, that.tradeId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(financialCode, that.financialCode) &&
                Objects.equals(branchId, that.branchId) &&
                Objects.equals(accountNo, that.accountNo) &&
                Objects.equals(fixedAccountNo, that.fixedAccountNo) &&
                Objects.equals(tradeStartDate, that.tradeStartDate) &&
                Objects.equals(maturityDay, that.maturityDay) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(ratio, that.ratio) &&
                Objects.equals(lastUpdatedAt, that.lastUpdatedAt) &&
                Objects.equals(ver, that.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tradeId, userId, financialCode, branchId, accountNo, fixedAccountNo, tradeStartDate, maturityDay, balance, ratio, lastUpdatedAt, ver);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "financial_code", referencedColumnName = "financial_code", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "branch_id", referencedColumnName = "branch_id", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "account_no", referencedColumnName = "account_no", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "fixed_account_no", referencedColumnName = "fixed_account_no", nullable = false, insertable = false, updatable = false)})
    public FixedDepositAccount getFixedDepositAccount() {
        return fixedDepositAccount;
    }

    public void setFixedDepositAccount(FixedDepositAccount fixedDepositAccount) {
        this.fixedDepositAccount = fixedDepositAccount;
    }

    @Basic
    @Column(name = "fixed_deposit_type", nullable = true, length = 50)
    public String getFixedDepositType() {
        return fixedDepositType;
    }

    public void setFixedDepositType(String fixedDepositType) {
        this.fixedDepositType = fixedDepositType;
    }

    @Basic
    @Column(name = "transaction_status", nullable = true, length = 50)
    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }



}
