package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "fixed_deposit_account", schema = "public", catalog = "mynavi_ib")
@IdClass(FixedDepositAccountPK.class)
public class FixedDepositAccount {
    private String userId;
    private String financialCode;
    private String branchId;
    private String accountNo;
    private String cifNo;
    private String fixedAccountNo;
    private String accountType;
    private Timestamp accountStartDate;
    private Timestamp lastUpdatedAt;
    private Integer ver;
    private Collection<FixedDeposit> fixedDeposits;
    private SavingsAccount savingsAccount;

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
    @Column(name = "cif_no", nullable = true, length = 7)
    public String getCifNo() {
        return cifNo;
    }

    public void setCifNo(String cifNo) {
        this.cifNo = cifNo;
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
    @Column(name = "account_type", nullable = true, length = 50)
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Basic
    @Column(name = "account_start_date", nullable = true)
    public Timestamp getAccountStartDate() {
        return accountStartDate;
    }

    public void setAccountStartDate(Timestamp accountStartDate) {
        this.accountStartDate = accountStartDate;
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
        FixedDepositAccount that = (FixedDepositAccount) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(financialCode, that.financialCode) &&
                Objects.equals(branchId, that.branchId) &&
                Objects.equals(accountNo, that.accountNo) &&
                Objects.equals(cifNo, that.cifNo) &&
                Objects.equals(fixedAccountNo, that.fixedAccountNo) &&
                Objects.equals(accountType, that.accountType) &&
                Objects.equals(accountStartDate, that.accountStartDate) &&
                Objects.equals(lastUpdatedAt, that.lastUpdatedAt) &&
                Objects.equals(ver, that.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, financialCode, branchId, accountNo, cifNo, fixedAccountNo, accountType, accountStartDate, lastUpdatedAt, ver);
    }

    @OneToMany(mappedBy = "fixedDepositAccount")
    public Collection<FixedDeposit> getFixedDeposits() {
        return fixedDeposits;
    }

    public void setFixedDeposits(Collection<FixedDeposit> fixedDeposits) {
        this.fixedDeposits = fixedDeposits;
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
