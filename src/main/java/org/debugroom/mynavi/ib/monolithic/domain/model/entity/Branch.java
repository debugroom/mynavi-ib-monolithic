package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "branch", schema = "public", catalog = "mynavi_ib")
@IdClass(BranchPK.class)
public class Branch {
    private String financialCode;
    private String branchId;
    private String branchName;
    private Timestamp lastUpdatedAt;
    private Integer ver;
    private FinancialInstitution financialInstitutionByFinancialCode;
    private Collection<SavingsAccount> savingsAccounts;

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
    @Column(name = "branch_name", nullable = true, length = 512)
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
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
        Branch branch = (Branch) o;
        return Objects.equals(financialCode, branch.financialCode) &&
                Objects.equals(branchId, branch.branchId) &&
                Objects.equals(branchName, branch.branchName) &&
                Objects.equals(lastUpdatedAt, branch.lastUpdatedAt) &&
                Objects.equals(ver, branch.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(financialCode, branchId, branchName, lastUpdatedAt, ver);
    }

    @ManyToOne
    @JoinColumn(name = "financial_code", referencedColumnName = "financial_code", nullable = false)
    public FinancialInstitution getFinancialInstitutionByFinancialCode() {
        return financialInstitutionByFinancialCode;
    }

    public void setFinancialInstitutionByFinancialCode(FinancialInstitution financialInstitutionByFinancialCode) {
        this.financialInstitutionByFinancialCode = financialInstitutionByFinancialCode;
    }

    @OneToMany(mappedBy = "branch")
    public Collection<SavingsAccount> getSavingsAccounts() {
        return savingsAccounts;
    }

    public void setSavingsAccounts(Collection<SavingsAccount> savingsAccounts) {
        this.savingsAccounts = savingsAccounts;
    }
}
