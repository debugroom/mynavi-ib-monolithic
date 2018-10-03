package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BranchPK implements Serializable {
    private String financialCode;
    private String branchId;

    @Column(name = "financial_code", nullable = false, length = 4)
    @Id
    public String getFinancialCode() {
        return financialCode;
    }

    public void setFinancialCode(String financialCode) {
        this.financialCode = financialCode;
    }

    @Column(name = "branch_id", nullable = false, length = 6)
    @Id
    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BranchPK branchPK = (BranchPK) o;
        return Objects.equals(financialCode, branchPK.financialCode) &&
                Objects.equals(branchId, branchPK.branchId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(financialCode, branchId);
    }
}
