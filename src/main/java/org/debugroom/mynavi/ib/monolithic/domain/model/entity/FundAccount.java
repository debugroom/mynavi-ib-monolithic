package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "fund_account", schema = "public", catalog = "mynavi_ib")
@IdClass(FundAccountPK.class)
public class FundAccount {
    private String userId;
    private String financialCode;
    private String branchId;
    private String accountNo;
    private String fundAccountNo;
    private String accountType;
    private Timestamp accountStartDate;
    private Timestamp lastUpdatedAt;
    private Integer ver;
    private SavingsAccount savingsAccount;
    private Collection<FundOrder> fundOrders;
    private String cifNo;

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
        FundAccount that = (FundAccount) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(financialCode, that.financialCode) &&
                Objects.equals(branchId, that.branchId) &&
                Objects.equals(accountNo, that.accountNo) &&
                Objects.equals(fundAccountNo, that.fundAccountNo) &&
                Objects.equals(accountType, that.accountType) &&
                Objects.equals(accountStartDate, that.accountStartDate) &&
                Objects.equals(lastUpdatedAt, that.lastUpdatedAt) &&
                Objects.equals(ver, that.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, financialCode, branchId, accountNo, fundAccountNo, accountType, accountStartDate, lastUpdatedAt, ver);
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

    @OneToMany(mappedBy = "fundAccount")
    public Collection<FundOrder> getFundOrders() {
        return fundOrders;
    }

    public void setFundOrders(Collection<FundOrder> fundOrders) {
        this.fundOrders = fundOrders;
    }

    @Basic
    @Column(name = "cif_no", nullable = true, length = 7)
    public String getCifNo() {
        return cifNo;
    }

    public void setCifNo(String cifNo) {
        this.cifNo = cifNo;
    }
}
