package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProspectusPK implements Serializable {
    private String fundId;
    private int prospectusNo;

    @Column(name = "fund_id", nullable = false, length = 8)
    @Id
    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    @Column(name = "prospectus_no", nullable = false)
    @Id
    public int getProspectusNo() {
        return prospectusNo;
    }

    public void setProspectusNo(int prospectusNo) {
        this.prospectusNo = prospectusNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProspectusPK that = (ProspectusPK) o;
        return prospectusNo == that.prospectusNo &&
                Objects.equals(fundId, that.fundId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fundId, prospectusNo);
    }
}
