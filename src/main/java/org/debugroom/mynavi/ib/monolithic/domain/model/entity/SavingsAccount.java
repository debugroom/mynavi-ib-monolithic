package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.debugroom.mynavi.ib.monolithic.apinfra.exception.BusinessException;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "savings_account", schema = "public", catalog = "mynavi_ib")
@IdClass(SavingsAccountPK.class)
public class SavingsAccount {
    private String userId;
    private String financialCode;
    private String branchId;
    private String cifNo;
    private String accountNo;
    private String accountType;
    private BigInteger totalAmount;
    private Timestamp accountStartDate;
    private Timestamp lastUpdatedAt;
    private Integer ver;
    private Collection<Deposit> deposits;
    private Collection<FixedDepositAccount> fixedDepositAccounts;
    private Collection<FundAccount> fundAccounts;
    private User userByUserId;
    private Branch branch;
    private Collection<Transfer> transfers;
    private Collection<ForeignCurrencyDepositAccount> foreignCurrencyDepositAccounts;

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

    @Basic
    @Column(name = "cif_no", nullable = true, length = 7)
    public String getCifNo() {
        return cifNo;
    }

    public void setCifNo(String cifNo) {
        this.cifNo = cifNo;
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
    @Column(name = "account_type", nullable = true, length = 50)
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Basic
    @Column(name = "total_amount", nullable = true, precision = 0)
    public BigInteger getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigInteger totalAmount) {
        this.totalAmount = totalAmount;
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
        SavingsAccount that = (SavingsAccount) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(financialCode, that.financialCode) &&
                Objects.equals(branchId, that.branchId) &&
                Objects.equals(cifNo, that.cifNo) &&
                Objects.equals(accountNo, that.accountNo) &&
                Objects.equals(accountType, that.accountType) &&
                Objects.equals(totalAmount, that.totalAmount) &&
                Objects.equals(accountStartDate, that.accountStartDate) &&
                Objects.equals(lastUpdatedAt, that.lastUpdatedAt) &&
                Objects.equals(ver, that.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, financialCode, branchId, cifNo, accountNo, accountType, totalAmount, accountStartDate, lastUpdatedAt, ver);
    }

    @OneToMany(mappedBy = "savingsAccount")
    public Collection<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(Collection<Deposit> deposits) {
        this.deposits = deposits;
    }

    @OneToMany(mappedBy = "savingsAccount")
    public Collection<FixedDepositAccount> getFixedDepositAccounts() {
        return fixedDepositAccounts;
    }

    public void setFixedDepositAccounts(Collection<FixedDepositAccount> fixedDepositAccounts) {
        this.fixedDepositAccounts = fixedDepositAccounts;
    }

    @OneToMany(mappedBy = "savingsAccount")
    public Collection<FundAccount> getFundAccounts() {
        return fundAccounts;
    }

    public void setFundAccounts(Collection<FundAccount> fundAccounts) {
        this.fundAccounts = fundAccounts;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)})
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "financial_code", referencedColumnName = "financial_code", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "branch_id", referencedColumnName = "branch_id", nullable = false, insertable = false, updatable = false)})
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @OneToMany(mappedBy = "savingsAccount")
    public Collection<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(Collection<Transfer> transfers) {
        this.transfers = transfers;
    }

    @OneToMany(mappedBy = "savingsAccount")
    public Collection<ForeignCurrencyDepositAccount> getForeignCurrencyDepositAccounts() {
        return foreignCurrencyDepositAccounts;
    }

    public void setForeignCurrencyDepositAccounts(Collection<ForeignCurrencyDepositAccount> foreignCurrencyDepositAccounts) {
        this.foreignCurrencyDepositAccounts = foreignCurrencyDepositAccounts;
    }

    public void addDeposit(Deposit deposit){
        getDeposits().add(deposit);
        addTotalAmount(deposit.getBalance());
    }

    public void addTotalAmount(BigInteger addMoney){
        setTotalAmount(getTotalAmount().add(addMoney));
    }

    public void subtractTotalAmount(BigInteger subtractMoney)
            throws BusinessException {
        if(getTotalAmount().compareTo(subtractMoney) < 0){
            throw new BusinessException("error.ordinary.deposit.0002",
                    "Insufficient balance for transfer order in finacode: [1], branch: [2], account: [3]",
                    financialCode, branchId, accountNo);
        }
        setTotalAmount(getTotalAmount().subtract(subtractMoney));
    }

}
