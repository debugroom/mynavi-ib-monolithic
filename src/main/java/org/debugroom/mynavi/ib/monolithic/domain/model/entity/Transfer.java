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
@IdClass(TransferPK.class)
public class Transfer {
    private String tradeId;
    private String userId;
    private String financialCode;
    private String branchId;
    private String accountNo;
    private BigInteger amount;
    private String transferTradeDay;
    private BigInteger fee;
    private Timestamp lastUpdatedAt;
    private Integer ver;
    private SavingsAccount savingsAccount;
    private String transferToFinancialCode;
    private String transferToBranchiId;
    private String transferToAccountNo;
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

    @Basic
    @Column(name = "amount", nullable = true, precision = 0)
    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "transfer_trade_day", nullable = true, length = 8)
    public String getTransferTradeDay() {
        return transferTradeDay;
    }

    public void setTransferTradeDay(String transferTradeDay) {
        this.transferTradeDay = transferTradeDay;
    }

    @Basic
    @Column(name = "fee", nullable = true, precision = 0)
    public BigInteger getFee() {
        return fee;
    }

    public void setFee(BigInteger fee) {
        this.fee = fee;
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
        Transfer transfer = (Transfer) o;
        return Objects.equals(tradeId, transfer.tradeId) &&
                Objects.equals(userId, transfer.userId) &&
                Objects.equals(financialCode, transfer.financialCode) &&
                Objects.equals(branchId, transfer.branchId) &&
                Objects.equals(accountNo, transfer.accountNo) &&
                Objects.equals(amount, transfer.amount) &&
                Objects.equals(transferTradeDay, transfer.transferTradeDay) &&
                Objects.equals(fee, transfer.fee) &&
                Objects.equals(lastUpdatedAt, transfer.lastUpdatedAt) &&
                Objects.equals(ver, transfer.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tradeId, userId, financialCode, branchId, accountNo, amount, transferTradeDay, fee, lastUpdatedAt, ver);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "financial_code", referencedColumnName = "financial_code", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "branch_id", referencedColumnName = "branch_id", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "account_no", referencedColumnName = "account_no", nullable = false, insertable = false, updatable = false)})
    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    @Basic
    @Column(name = "transfer_to_financial_code", nullable = true, length = 4)
    public String getTransferToFinancialCode() {
        return transferToFinancialCode;
    }

    public void setTransferToFinancialCode(String transferToFinancialCode) {
        this.transferToFinancialCode = transferToFinancialCode;
    }

    @Basic
    @Column(name = "transfer_to_branchi_id", nullable = true, length = 6)
    public String getTransferToBranchiId() {
        return transferToBranchiId;
    }

    public void setTransferToBranchiId(String transferToBranchiId) {
        this.transferToBranchiId = transferToBranchiId;
    }

    @Basic
    @Column(name = "transfer_to_account_no", nullable = true, length = 7)
    public String getTransferToAccountNo() {
        return transferToAccountNo;
    }

    public void setTransferToAccountNo(String transferToAccountNo) {
        this.transferToAccountNo = transferToAccountNo;
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
