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
@Table(name = "financial_institution", schema = "public", catalog = "mynavi_ib")
public class FinancialInstitution {
    private String financialCode;
    private String financialInstitutionName;
    private Timestamp lastUpdatedAt;
    private Integer ver;
    private Collection<Branch> branchesByFinancialCode;
    private Collection<Fund> fundsByFinancialCode;

    @Id
    @Column(name = "financial_code", nullable = false, length = 4)
    public String getFinancialCode() {
        return financialCode;
    }

    public void setFinancialCode(String financialCode) {
        this.financialCode = financialCode;
    }

    @Basic
    @Column(name = "financial_institution_name", nullable = true, length = 512)
    public String getFinancialInstitutionName() {
        return financialInstitutionName;
    }

    public void setFinancialInstitutionName(String financialInstitutionName) {
        this.financialInstitutionName = financialInstitutionName;
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
        FinancialInstitution that = (FinancialInstitution) o;
        return Objects.equals(financialCode, that.financialCode) &&
                Objects.equals(financialInstitutionName, that.financialInstitutionName) &&
                Objects.equals(lastUpdatedAt, that.lastUpdatedAt) &&
                Objects.equals(ver, that.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(financialCode, financialInstitutionName, lastUpdatedAt, ver);
    }

    @OneToMany(mappedBy = "financialInstitutionByFinancialCode")
    public Collection<Branch> getBranchesByFinancialCode() {
        return branchesByFinancialCode;
    }

    public void setBranchesByFinancialCode(Collection<Branch> branchesByFinancialCode) {
        this.branchesByFinancialCode = branchesByFinancialCode;
    }

    @OneToMany(mappedBy = "financialInstitutionByFinancialCode")
    public Collection<Fund> getFundsByFinancialCode() {
        return fundsByFinancialCode;
    }

    public void setFundsByFinancialCode(Collection<Fund> fundsByFinancialCode) {
        this.fundsByFinancialCode = fundsByFinancialCode;
    }
}
